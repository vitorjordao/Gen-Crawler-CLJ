(def project 'gen-crawler-clj)
(def version "1.0.0-ALPHA")

(set-env! :resource-paths #{"resources" "src"}
          :source-paths   #{"test"}
          :dependencies   '[[org.clojure/clojure "RELEASE"]
                            [br.com.gencrawler.crawler/gen-crawler "1.2.1-BETA"]
                            [adzerk/boot-test "RELEASE" :scope "test"]
                            [midje "1.9.9"]])

(task-options!
 aot {:namespace   #{'simple-collector}}
 pom {:project     project
      :version     version
      :description "FIXME"
      :url         "https://github.com/vitorjordao/gen-crawler-clj"
      :scm         {:url "https://github.com/vitorjordao/gen-crawler-clj"}
      :license     {"Mozilla Public License 2.0 "
                    "https://www.mozilla.org/en-US/MPL/2.0/"}}
 repl {:init-ns    'simple-collector}
 jar {:main        'simple-collector
      :file        (str "gen-crawler-clj-" version "-standalone.jar")})

(deftask build
  "Build the project locally as a JAR."
  [d dir PATH #{str} "the set of directories to write to (target)."]
  (let [dir (if (seq dir) dir #{"target"})]
    (comp (aot) (pom) (uber) (jar) (target :dir dir))))

(require '[adzerk.boot-test :refer [test]])
