(ns double-book)

(defn overlap? [event1 event2]
  (let [[start1 end1] [(get event1 :start-time) (get event1 :end-time)]
        [start2 end2] [(get event2 :start-time) (get event2 :end-time)]]
    (or (and (<= start1 start2) (> end1 start2))
      (and (<= start2 start1) (> end2 start1)))))



(defn find-overlapping-pairs [events]
  (let [pairs (for [i (range (count events))
                    j (range (inc i) (count events))]
                [(nth events i) (nth events j)])]
    (filter #(apply overlap? %) pairs)))
