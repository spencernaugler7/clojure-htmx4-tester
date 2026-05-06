(ns test-clojure.setup
  (:require
   [hbs.core :as hbs]))

(def reg (hbs/registry (hbs/file-loader "resources" ".tpl")))