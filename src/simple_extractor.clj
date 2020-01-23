(ns simple-extractor)

(defn run-item
  "
  Run the extractor item without AJAX
  ´item´
  => {:url \"...\", :paginator \"...\", :link_finded \"...\", :match \"...\"}
  ´url´ => string
  ´paginator´ => string => regex
  ´link_finded´ => string
  ´match´ => string => regex
  "
  [{url :url, paginator :paginator, link_finded :link_finded, match :match}]
  (let [obj (br.com.gencrawler.crawler.core.SimpleExtractor. url paginator link_finded match)]
    (.run obj)
    (->>
     (.getItems obj)
     (vec)
     (filter #(not-empty %)))))

(defn run-list
  "
  Run the extractors items without AJAX
  ´item´
  => [{:url \"... \", :paginator \"... \", :link_finded \"... \", :match \"... \"}]
  ´url´ => string
  ´paginator´ => string => regex
  ´link_finded´ => string
  ´match´ => string => regex
  "
  [& args]
  (map #(run-item %) args))
