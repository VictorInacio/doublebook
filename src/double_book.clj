(ns double-book)

(defn overlap? [event1 event2]
  (let [[start1 end1] [(get event1 :start-time) (get event1 :end-time)]
        [start2 end2] [(get event2 :start-time) (get event2 :end-time)]]
    (or (and (<= start1 start2) (> end1 start2))
      (and (<= start2 start1) (> end2 start1)))))

#_(defn find-overlapping-pairs
  "Find all overlapping pairs of events"
  [events]
  (let [events-count (count events)                         ;; Used for pairs assembly
        pairs (mapcat (fn [i]                               ;; Creates all combinations of event pairs
                        (map (fn [j]
                               [(nth events i) (nth events j)])
                          (range (inc i) events-count)))
                (range events-count))]
    (filter #(apply overlap? %) pairs)))

(defn find-overlapping-pairs [events]
  (let [pairs (for [i (range (count events))
                    j (range (inc i) (count events))]
                [(nth events i) (nth events j)])]
    (filter #(apply overlap? %) pairs)))
