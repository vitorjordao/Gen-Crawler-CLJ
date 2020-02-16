(ns simple-collector)


(defn run-item
  "
  Run the collector item without AJAX
  ´item´
  => {:url \"...\", :find \"...\", :match \"...\"}
  ´url´ => string
  ´find´ => string
  ´match´ => string => regex
  "
  [{url :url, find :find, match :match}]
  (let [obj (br.com.gencrawler.crawler.core.SimpleCollector. url find match)]
    (.run obj)
    (let [items (->>
                 (.getItems obj)
                 (vec)
                 (filter #(not-empty %)))
          links (->>
                 (.getItems obj)
                 (hash-set))]
      {:items items :links links})))

(defn run-list 
  "
  Run the collector item list without AJAX
  ´items´
  => [{:url \"...\", :find \"...\", :match \"...\"}]
  ´url´ => string
  ´find´ => string
  ´match´ => string => regex
  "
  [& items]
  (map #(run-item %) items))
