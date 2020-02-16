(ns ajax-collector)

(defn set-driver 
  "
  Run the collector item with AJAX
  ´item´
  => {:driver \"... \", :url-driver \"... \"}
  ´driver´ => string
  ´url-driver´ => string
  "
  [{driver :driver url-driver :url-driver}]
  (System/setProperty driver url-driver))

(defn run-item
  "
  Run the collector item with AJAX
  ´item´
  => {:url \"...\", :find \"...\", :match \"...\"}
  ´url´ => string
  ´find´ => string
  ´match´ => string => regex
  "
  [{url :url, find :find, match :match}]
  (let [obj (br.com.gencrawler.crawler.core.AjaxCollector. url find match)]
    (.run obj)
    
     (let [items (->>
                 (.getItems obj)
                 (vec)
                 (filter #(not-empty %)))
           links (->>
                 (.getURLs obj)
                 (hash-set))]
       {:items items :links links})))

(defn- exec-each-item
  "Run ajax crawler for each item"
  [{find :find match :match url :url} obj]
  (.clearItems obj)
  (.set obj find match url)
  (.runBrowser obj)
  (let [items (->>
               (.getItems obj)
               (vec)
               (filter #(not-empty %)))
        links (->>
               (.getURLs obj)
               (hash-set))]
    {:items items :links links})
  )

(defn run-list
  "
  Run the collector item list with AJAX
  ´items´
  => [{:url \"...\", :find \"...\", :match \"...\"}]
  ´url´ => string
  ´find´ => string
  ´match´ => string => regex
  "
  [& items]
  (let [obj (br.com.gencrawler.crawler.core.AjaxCollector.)]
    (.openBrowser obj (count items))
    (let [result (mapcat
                  #(exec-each-item %1 obj)
                  items)]
      (.closeBrowser obj)
      result)))
