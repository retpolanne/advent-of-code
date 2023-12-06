(ns aoc-day1-part2.core-test
  (:require [clojure.test :refer :all]
            [aoc-day1-part2.core :refer :all]))

(def test-input "two1nine
eightwothree
abcone2threexyz
xtwone3four
4nineeightseven2
zoneight234
7pqrstsixteen")

(deftest is-number-test
  (testing "Test if character is number or not"
    (is (true? (is-number? "1")))
    (is (false? (is-number? "a")))))

(deftest filter-numbers-test
  (testing "Filter numbers - only first and last number"
    (is (= (filter-numbers "eight2three") 83))
    (is (= (filter-numbers "2twonszcpthreeeightsixsevensevendbllrvdtqv") 27))
    (is (= (filter-numbers "752seven") 77))
    (is (= (filter-numbers "2") 22))
    (is (= (filter-numbers "two") 22))
    (is (= (filter-numbers "eighthree") 83))))

(deftest filter-numbers-test
  (testing "Filter numbers - only first and last number"
    (is (= (filter-numbers "678973") 63))))

(deftest filter-numbers-string-test
  (testing "Filtering numbers from a string with \\n" 
    (is (= (filter-numbers-string test-input) [29 83 13 24 42 14 76]))))

(deftest sum-numbers-string-test
  (testing "Sum the numbers from a string with \\n"
    (is (= (sum-numbers-array test-input) 281))))

(deftest get-only-numbers-in-string-test
  (testing "Filter number array to get only numbers that show up in the string"
    (is (= (get-only-numbers-in-string "twosixseventhree") {"six" "6", "three" "3", "two" "2", "seven" "7"}))
    (is (= (get-only-numbers-in-string "eighthree") {"eight" "8", "three" "3"}))))

(deftest sort-numbers-by-string-test
  (testing "Sort numbers in number array by the position where they appear in the string"
    (is (= (sort-numbers-by-string "eightwo3") {"eight" "8" "two" "2"}))
    (is (= (sort-numbers-by-string "zoneight234") {"one" "1" "eight" "8"}))))

(deftest change-numbertext-numbers-test
  (testing "Turn number names into numbers"
    (is (= (change-numbertext-numbers "nine32fourh") "9324h"))
    (is (= (change-numbertext-numbers "eightwo3") "8wo3"))
    (is (= (change-numbertext-numbers "eightwosix3") "8wo63"))))

(deftest change-numbertext-string-test
  (testing "Turn number names into numbers from a string with \\n"
    (is (= (change-numbertext-string test-input) ["219" "8wo3" "abc123xyz" "x2ne34" "49872" "z1ight234" "7pqrst6teen"]))))

;; Opening the file and getting the answer :) 
(sum-numbers-string (slurp "input.txt"))
