(ns simple-collector-test
  (:require [midje.sweet :refer [facts fact =>]]
            [simple-collector :refer [run-list run-item]]))

(facts "Run collectors without AJAX"
       (let [crawled {:url "https://www.casa.center/prato-de-sobremesa-com-estampa-de-flores-e-borda-bambu-magnolia/p"
                      :find "strong[class^=\"skuPrice\"]"
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
