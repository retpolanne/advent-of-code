(ns aoc-day1-part2.core
  (:gen-class)
  (:require [clojure.string :as str]))

(def numbers {
              "one" "1"
              "two" "2"
              "three" "3"
              "four" "4"
              "five" "5"
              "six" "6"
              "seven" "7"
              "eight" "8"
              "nine" "9"})

(defn is-number? [character]
  (try
    (Integer/parseInt character) true
    (catch java.lang.NumberFormatException e false)))

(defn get-only-numbers-in-string [mixed-line]
  (select-keys numbers (filter #(str/includes? mixed-line %) (keys numbers))))

(defn sort-numbers-by-string [mixed-line]
  (into (sorted-map-by (fn [key1 key2]
                         (compare (str/index-of mixed-line key1)
                                  (str/index-of mixed-line key2))))
        (get-only-numbers-in-string mixed-line)))

(defn change-numbertext-numbers [mixed-line]
  (reduce #(apply clojure.string/replace %1 %2) mixed-line (sort-numbers-by-string mixed-line)))

(defn change-numbertext-string [whole-string]
  (vec (map #(change-numbertext-numbers %) (str/split whole-string #"\n"))))

(defn filter-numbers [mixed-line]
  (def str-array (filter not-empty (str/split (change-numbertext-numbers mixed-line) #"")))
  (def num-array (filter is-number? str-array))
  (Integer/parseInt (apply str [(first num-array) (last num-array)])))

(defn filter-numbers-string [whole-string]
  (vec (map #(filter-numbers %) (str/split whole-string #"\n"))))

(defn sum-numbers-string [whole-string]
  (reduce + (filter-numbers-string whole-string)))
