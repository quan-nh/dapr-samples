(defproject hello-world "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-core "1.7.1"]
                 [http-kit "2.3.0"]
                 [compojure "1.6.1"]
                 [metosin/muuntaja "0.6.5"]]
  
  :main ^:skip-aot hello-world.core
  :profiles {:uberjar {:aot :all}}
  
  :plugins [[lein-protoc "0.5.0"]]
  
  :protoc-version "3.10.0"
  :protoc-grpc {:version "1.24.0"}
                      
  :source-paths ["src/clj"]
  :java-source-paths ["target/generated-sources/protobuf"])
