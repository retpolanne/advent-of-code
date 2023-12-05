(ns aoc-day1.core-test
  (:require [clojure.test :refer :all]
            [aoc-day1.core :refer :all]))

(def test-input "1abc2
pqr3stu8vwx
a1b2c3d4e5f
treb7uchet")

(deftest is-number-test
  (testing "Test if character is number or not"
    (is (true? (is-number? "1")))
    (is (false? (is-number? "a")))))

(deftest filter-numbers-test
  (testing "Filter numbers - only first and last number"
    (is (= (filter-numbers "a1b2c3d4e5f") 15))))

(deftest filter-numbers-test
  (testing "Filter numbers - only first and last number"
    (is (= (filter-numbers "678973") 63))))

(deftest filter-numbers-string-test
  (testing "Filtering numbers from a string with \n" 
    (is (= (filter-numbers-string test-input) [12 38 15 77]))))

(deftest sum-numbers-string-test
  (testing "Sum the numbers from a string with \n"
    (is (= (sum-numbers-string test-input) 142))))
