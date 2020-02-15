(def version "0.5.0-BETA")
(defproject gen-crawler-clj version
  :description "FIXME"
  :uberjar-name (str "gen-crawler-clj-" version ".jar")
  :url "https://github.com/vitorjordao/gen-crawler-clj"
  :min-lein-version "2.0.0"
  :license     {"Mozilla Public License 2.0 "
                "https://www.mozilla.org/en-US/MPL/2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [br.com.gencrawler.crawler/gen-crawler "0.5.0-BETA"]
                 [midje "1.9.9"]
                 [org.apache.maven.wagon/wagon-ssh-external "2.6"]]
  :plugins [[lein-midje "3.2.1"]]
  :profiles {:uberjar {:aot :all}}
  :repositories [["releases" "https://clojars.org/repo"]]
  
  :source-paths
  ["src"]

  :java-source-paths
  ["src"]

  :test-paths
  ["test"])
