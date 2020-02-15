(ns ajax-collector-test
  (:require [midje.sweet :refer [facts fact =>]]
            [ajax-collector :refer [run-list run-item set-driver]]))

(set-driver {:driver "webdriver.chrome.driver"
             :url-driver "/home/v/path/chromedriver"})

(facts "Run collectors without AJAX"
       (let [crawled {:url "https://www.casa.center/prato-de-sobremesa-com-estampa-de-flores-e-borda-bambu-magnolia/p"
                      :find ".bf-price__best"
                      :match "^.*?().*$"}]
         (fact "Get a prices on the site"
               (->
                (run-item crawled)
                (count)
                (> 0)) => true)

         (fact "Get a list prices on the site"
               (->
                (run-list crawled crawled)
                (count)
                (> 0)) => true)))