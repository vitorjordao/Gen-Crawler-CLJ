(ns simple-extractor-test
  (:require [midje.sweet :refer [facts fact =>]]
            [simple-extractor :refer [run-list run-item]]))

(facts "Run extractors without AJAX"
       (let [crawled {:url "https://www.americanas.com.br/categoria/livros/didaticos-e-educacao/ensino-fundamental-6o-ao-9o-ano?ordenacao=topSelling&origem=omega&chave=brd_hs_dt_0_livros-6-ao-9_material-escolar18&pfm_carac=BLOCO%201&pfm_index=0&pfm_page=special&pfm_pos=contenttop3&pfm_type=vit_spacey"
                      :paginator "a[href^=\"/categoria/livros/didaticos-e-educacao/ensino-fundamental-6o-ao-9o-ano?\"]"
                      :link_finded "div[class^=\"product-grid-item\"] a[class^=\"Link-bwhjk3-2\"]"
                      :match "^.*?().*$"}]
         (fact "Get a lot of prices on the site"
               (->
                (run-item crawled)
                (count)
                (> 0)) => true)

         (fact "Get a list prices on the site"
               (->
                (run-list crawled crawled)
                (count)
                (> 0)) => true)))