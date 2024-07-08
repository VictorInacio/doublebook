(ns main
  (:require [double-book :as d]
            [clojure.edn :as edn])
  (:gen-class))

(defn -main [args]
  (let [events (-> args slurp edn/read-string)]
    (println "Overlapping events: " (d/find-overlapping-pairs events))))
