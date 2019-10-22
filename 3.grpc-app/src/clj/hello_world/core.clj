(ns hello-world.core
  (:gen-class)
  (:require [compojure.core :refer [defroutes GET POST]]
            [jsonista.core :as json]
            [muuntaja.middleware :as mw]
            [org.httpkit.server :refer [run-server]]
            [org.httpkit.client :as http]))

(def dapr-port (or (System/getenv "DAPR_HTTP_PORT") 3500))
(def state-url (str "http://localhost:" dapr-port "/v1.0/state"))

(defroutes app-routes
  (GET "/order" []
    (:body @(http/get (str state-url "/order"))))
  
  (POST "/neworder" {{:keys [data]} :body-params}
    (println "Got a new order! Order ID:" (:orderId data))
    (http/post state-url
               {:headers {"Content-Type" "application/json"}
                :body (json/write-value-as-string [{:key "order"
                                                    :value data}])}
               (fn [{:keys [error]}]
                 (if error
                   (println "Failed to persist state, exception is " error)
                   (println "Successfully persisted state"))))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (-> app-routes
      (mw/wrap-format)
      (run-server {:port 3000})))
