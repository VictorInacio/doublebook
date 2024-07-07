(ns event-schema
  (:require [malli.core :as m]
    [malli.transform :as mt]
    [malli.json-schema :as mj])
  (:import [java.time ZonedDateTime]))

;; Malli schema for an event
(def event-schema
  [:map
   [:start [:fn (fn [x] (instance? ZonedDateTime x))]]
   [:end [:fn (fn [x] (instance? ZonedDateTime x))]]])
