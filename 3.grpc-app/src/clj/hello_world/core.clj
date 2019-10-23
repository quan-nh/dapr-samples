(ns hello-world.core
  (:gen-class)
  (:import (io.dapr DaprGrpc DaprProtos$GetStateEnvelope DaprClientGrpc$DaprClientImplBase DaprClientProtos$InvokeEnvelope)
           (io.grpc ManagedChannelBuilder ServerBuilder)))

(def dapr-port (System/getenv "DAPR_GRPC_PORT"))
(def SERVER_PORT 4000)

(def client (DaprGrpc/newBlockingStub
              (-> (ManagedChannelBuilder/forAddress "localhost" (Integer/valueOf dapr-port))
                  (.usePlaintext true)
                  .build)))

#_(defroutes app-routes
             (GET "/order" []
                  )

             (POST "/neworder" {{:keys [data]} :body-params}
                   (println "Got a new order! Order ID:" (:orderId data))
                   (http/post state-url
                              {:headers {"Content-Type" "application/json"}
                               :body    (json/write-value-as-string [{:key   "order"
                                                                      :value data}])}
                              (fn [{:keys [error]}]
                                (if error
                                  (println "Failed to persist state, exception is " error)
                                  (println "Successfully persisted state"))))))

(defn make-service []
  (proxy [DaprClientGrpc$DaprClientImplBase] []
    (onInvoke [^DaprClientProtos$InvokeEnvelope req resp]
      (case (.getMethod req)
        "order"
        (let [order-state (.getState client (-> (DaprProtos$GetStateEnvelope/newBuilder)
                                                (.setKey "order")
                                                .build))
              order (-> order-state .getData .getValue .toStringUtf8)]
          (.onNext resp order)
          (.onCompleted resp))))))

(defn -main [& args]
  (println "App listening on port " SERVER_PORT)
  (let [service (make-service)
        server (-> (ServerBuilder/forPort SERVER_PORT)
                   (.addService service)
                   (.build))]
    (.start server)))
