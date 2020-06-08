# gen-crawler-clj

Project based on https://github.com/vitorjordao/Gen-Crawler

This is a crawler project make in Clojure language

[![Clojars Project](https://img.shields.io/clojars/v/gen-crawler-clj.svg)](https://clojars.org/gen-crawler-clj)

## How to start

There are two methods to build your crawler, the first one is simple-collector, this method is focused in performance, it's will make so downloading the HTML page and extracting the information, the second method is ajax-collector, it's focused in will working at pages with AJAX.

### simple-collector

#### Dictionay/map params

```
(def crawled {:url <URL>
            :find <FINDER>
            :match <MATCHER>})
```

URL     = Crawled url page         = "https://www.americanas.com.br/produto/122597474/10692-lego-classic-pecas-criativas?pfm_carac=lego&pfm_page=search&pfm_pos=grid&pfm_type=search_page"

FINDER  = CSS selector             = ".price__SalesPrice-ej7lo8-2"

MATCHER = Regex applied in the tag = "^.*?().*$"

#### Run and ruturn params

##### For one item

```
(def returned (simple-collector/run-item crawled))
```

##### For many items

```
(def returned (simple-collector/run-list crawled crawled))
```

### ajax-collector

#### Set a chromedriver:

```
System.setProperty("webdriver.chrome.driver", <PATH>);
```

PATH = A path for chromedriver = "./chromedriver"

#### Dictionay/map params

```
(def crawled {:url <URL>
            :find <FINDER>
            :match <MATCHER>})
```

URL     = Crawled url page         = "https://www.americanas.com.br/produto/122597474/10692-lego-classic-pecas-criativas?pfm_carac=lego&pfm_page=search&pfm_pos=grid&pfm_type=search_page"

FINDER  = CSS selector             = ".price__SalesPrice-ej7lo8-2"

MATCHER = Regex applied in the tag = "^.*?().*$"

#### Run and ruturn params

##### For one item

```
(def returned (ajax-collector/run-item crawled))
```

##### For many items

```
(def returned (ajax-collector/run-list crawled crawled))
```

## Test

Run the project's tests (they'll fail until you edit them):

    $ lein test

## Build

Build an uberjar from the project:

    $ lein install

# Help with grammar and spelling errors:
Because I am not fluent in English, they are likely to have grammar and spelling mistakes, so I will accept any help in this.

# Help with documentation:
I accept any help with the documentation you add to the project.

# Help with the code:
Any help in the code that helps to improve the quality or quantity of futures will be totally welcome.
