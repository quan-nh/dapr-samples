(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-core "1.7.1"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [metosin/muuntaja "0.6.5"]
                 [io.grpc/grpc-netty "1.24.0"]
                 [io.grpc/grpc-protobuf "1.24.0"]
                 [io.grpc/grpc-stub "1.24.0"]
                 [javax.annotation/javax.annotation-api "1.2"]]
  
  :main ^:skip-aot hello-world.core
  :profiles {:uberjar {:aot :all}}
  
  :plugins [[lein-protoc "0.5.0"]]
  
  :protoc-version "3.9.0"
  :protoc-grpc {:version "1.24.0"}
  :proto-target-path "src/generated-sources/protobuf"

  :source-paths ["src/clj"]
  :java-source-paths ["src/generated-sources/protobuf"])
