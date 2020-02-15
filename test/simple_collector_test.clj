(ns simple-collector-test
  (:require [midje.sweet :refer [facts fact =>]]
            [simple-collector :refer [run-list run-item]]))

(facts "Run collectors without AJAX"
       (let [crawled {:url "https://www.americanas.com.br/produto/116802208/livro-geografia-espaco-e-vivencia-8o-ano?pfm_carac=Ensino%20Fundamental%20-%206%C2%BA%20ao%209%C2%BA%20ano&pfm_index=1&pfm_page=category&pfm_pos=grid&pfm_type=vit_product_grid"
                      :find ".price__SalesPrice-ej7lo8-2"
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
