(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [io.grpc/grpc-netty "1.24.0"]
                 [io.grpc/grpc-protobuf "1.24.0"]
                 [io.grpc/grpc-stub "1.24.0"]
                 [javax.annotation/javax.annotation-api "1.2"]]
  
  :main ^:skip-aot hello-world.core
  :profiles {:uberjar {:aot :all}}
  
  :plugins [[lein-protoc "0.5.0"]]
  
  :protoc-version "3.9.0"
  :protoc-grpc {:version "1.24.0"}
  :proto-target-path "generated-sources/protobuf"

  :source-paths ["src/clj"]
  :java-source-paths ["generated-sources/protobuf"])
