(ns simple-collector-test
  (:require [midje.sweet :refer [facts fact =>]]
            [simple-collector :refer [run-list run-item]]))

(facts "Run collectors without AJAX"
       (fact "Run an item"
             (run-item {}) => {})
       
       (fact "Run a lot of items"
             (run-list {} {}) => []))
