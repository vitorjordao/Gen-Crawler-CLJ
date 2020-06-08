(ns simple-collector-test
  (:require [midje.sweet :refer [facts fact =>]]
            [simple-collector :refer [run-list run-item]]))

(facts "Run collectors without AJAX"
       (let [crawled {:url "https://www.americanas.com.br/produto/122597474/10692-lego-classic-pecas-criativas?pfm_carac=lego&pfm_page=search&pfm_pos=grid&pfm_type=search_page"
                      :find ".price__SalesPrice-ej7lo8-2"
                      :match "^.*?().*$"}
             {prices :items links :links} (run-item crawled)]
         (fact "Get the prices on the site"
               (->
                prices
                (count)
                (> 0)) => true)
         (fact "Get the links on the site"
               (->
                links
                (count)
                (> 0)) => true)

         (fact "Get a list prices on the site"
               (->
                (run-list crawled crawled)
                (count)
                (> 0)) => true)))
