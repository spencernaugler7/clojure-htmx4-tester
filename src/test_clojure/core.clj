(ns test-clojure.core
  (:require [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [ring.util.response :as response]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
  (:gen-class))


(defroutes app-routes
  (GET "/" [] (response/redirect "/contacts"))
  (GET "/contacts" [] "Hello Contacts")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults #'app-routes site-defaults))

(defn -main []
  (jetty/run-jetty #'app {:port 3000}))