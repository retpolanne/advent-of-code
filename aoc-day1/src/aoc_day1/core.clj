(ns aoc-day1.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn is-number? [character]
  (try
    (Integer/parseInt character) true
    (catch java.lang.NumberFormatException e false)))

(defn filter-numbers [mixed-line]
  (def str-array (filter not-empty (str/split mixed-line #"")))
  (def num-array (filter is-number? str-array))
  (Integer/parseInt (apply str [(first num-array) (last num-array)])))

(defn filter-numbers-string [whole-string]
  (vec (map #(filter-numbers %) (str/split whole-string #"\n"))))

(defn sum-numbers-string [whole-string]
  (reduce + (filter-numbers-string whole-string)))
