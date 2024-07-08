(ns event-schema
  (:require [malli.core :as m]
    [malli.generator :as mg]))


;; Time formats will be Unix timestamp represented as integers
(def UnixTimestamp
  [:and :int [:> 0]])

;; Malli schema for an event assuming an event-id and event-text for simple examples
(def event-schema
  [:map
   [:event-id [:int {:min 0}]]
   [:event-text [:string {:min 1}]]
   [:start-time UnixTimestamp]
   [:end-time UnixTimestamp]])


(comment
  (mg/generate event-schema)
  (m/validate event-schema {:event-id   124484534
                            :start-time 1720471157
                            :end-time   1720471157
                            :event-text "Status Meeting"})

  )



