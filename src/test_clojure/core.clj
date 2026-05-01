(ns test-clojure.core
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.util.request :as request]
            [clojure.string :as s]
            [ring.util.response :as response]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))

(def contacts #{"jeff" "blan" "john" "doe"})

(defn render-contacts [contacts]
  )

(defn get-contacts [search]
  (->> contacts
       (filter (fn [s] (s/includes? s "j")))
       (s/join ", ")))

(defroutes app-routes
  (GET "/" [] (response/redirect "/contacts"))
  (GET "/contacts" [] (get-contacts "s"))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults #'app-routes site-defaults))

(defn -main []
  (jetty/run-jetty #'app {:port 3000}))