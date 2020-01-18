(ns simple-collector)


(defn run-item
  "
  Run the collector item without AJAX
  ´item´ is a map 
  => {:url \"...\", :find \"...\", :match \"...\"}
  "
  [{url :url, find :find, match :match}]
  (let [obj (br.com.gencrawler.crawler.core.SimpleCollector. url find match)]
    (.run obj)
    (->>
     (.getItems obj)
     (vec)
     (filter #(not-empty %)))))

(defn run-list 
  "
  Run the collector item without AJAX
  ´item´ is a map 
  => {:url \"...\", :find \"...\", :match \"...\"}
  "
  [& args]
  (map #(run-item %) args))

