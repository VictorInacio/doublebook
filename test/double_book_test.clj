(ns double-book-test
  (:require [clojure.test :refer :all]
            [double-book :refer :all]))

(deftest test-no-overlapping-pair
  (let [events   [{:start-time 1720400000
                   :end-time   1720410000}
                  {:start-time 1720420000
                   :end-time   1720430000}]
        expected '()]
    (is (= expected (find-overlapping-pairs events)) "no overlap")))

(deftest test-overlapping-pairs
  (let [events   [{:start-time 1720400000
                   :end-time   1720410000}
                  {:start-time 1720400000
                   :end-time   1720405000}]
        expected '([{:start-time 1720400000
                     :end-time   1720410000}
                    {:start-time 1720400000
                     :end-time   1720405000}])]
    (is (= expected (find-overlapping-pairs events)) "one overlap")))

(deftest test-multiple-overlapping-pairs
  (let [events   [{:start-time 1720400000
                   :end-time   1720410000}
                  {:start-time 1720400000
                   :end-time   1720405000}
                  {:start-time 1720404000
                   :end-time   1720407000}]
        expected '([{:start-time 1720400000, :end-time 1720410000}
                    {:start-time 1720400000, :end-time 1720405000}]
                   [{:start-time 1720400000, :end-time 1720410000}
                    {:start-time 1720404000, :end-time 1720407000}]
                   [{:start-time 1720400000, :end-time 1720405000}
                    {:start-time 1720404000, :end-time 1720407000}])]
    (is (= expected (find-overlapping-pairs events)) "multiple events all overlaps")))

(deftest test-multiple-some-overlaps-pairs
  (let [events   [{:start-time 1720400000
                   :end-time   1720410000}
                  {:start-time 1720400000
                   :end-time   1720405000}
                  {:start-time 1720404000
                   :end-time   1720407000}
                  {:start-time 1820404000
                   :end-time   1820407000}]
        expected '([{:start-time 1720400000, :end-time 1720410000}
                    {:start-time 1720400000, :end-time 1720405000}]
                   [{:start-time 1720400000, :end-time 1720410000}
                    {:start-time 1720404000, :end-time 1720407000}]
                   [{:start-time 1720400000, :end-time 1720405000}
                    {:start-time 1720404000, :end-time 1720407000}])]
    (is (= expected (find-overlapping-pairs events)) "multiple events some overlaps")))

(deftest test-multiple-no-overlaps
  (let [events   [{:start-time 1720400000
                   :end-time   1720410000}
                  {:start-time 1720420000
                   :end-time   1720430000}
                  {:start-time 1720440000
                   :end-time   1720450000}]
        expected '()]
    (is (= expected (find-overlapping-pairs events)) "multiple events no overlaps")))

(deftest test-empty-events
  (let [events   []
        expected '()]
    (is (= expected (find-overlapping-pairs events)) "empty events")))

