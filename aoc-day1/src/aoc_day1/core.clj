(ns aoc-day1.core
  (:gen-class)
  (:require [clojure.string :as str]))

(defn filter-numbers [mixed-line]
  (println mixed-line)
  (def num-array (filter not-empty (str/split mixed-line #"[a-z]")))
  (Integer/parseInt (apply str [(first num-array) (last num-array)])))

(defn filter-numbers-string [whole-string]
  (vec (map #(filter-numbers %) (str/split whole-string #"\n"))))

(defn sum-numbers-string [whole-string]
  (reduce + (filter-numbers-string whole-string)))

(def input (slurp "input.txt"))

(sum-numbers-string input)
