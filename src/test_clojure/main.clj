(ns test-clojure.main
  (:require [clojure.core.reducers]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :as route]
            [hbs.core :as hbs]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [site-defaults wrap-defaults]]
            [test-clojure.setup :refer [reg]])
  (:gen-class))

(def contacts [{:name "Jeff"}
               {:name "Blan"}
               {:name "James"}
               {:name "Doe"}])

(defroutes app-routes
  (GET "/html" [firstname lastname]
    (hbs/render-file reg "layout.html" {:firstName firstname
                                        :lastName lastname
                                        :contacts contacts}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults #'app-routes site-defaults))

(defn -main []
  (jetty/run-jetty #'app {:port 3000}))