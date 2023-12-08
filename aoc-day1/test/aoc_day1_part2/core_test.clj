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

(def test-real-input "five8b
2733vmmpknvgr
3oneeighttwo
twofourfive485
2fourghsixptk
5fivezgfgcxbf3five
eighthtkk5
qjqpnfs812sevensbjlkzrzczdmsr
cpxtthree14
pljnzhchrrqvkncfnfive6four7dzqkfslm9
dlrczxpfxp1
sixsix35
twoxldv5rftbpfivevqtphhxvgzkhbg
zsjtsvjtlrsdsvqgfouronexhnbgpsl8
five813
53eightfourlseven5bvtmzfkqc6
51two8eightseven
frfshfjvlhgsjvmxbplkmsm1seven")

(def test-map-real-input {"five8b" 58
                          "2733vmmpknvgr" 23
                          "3oneeighttwo" 32
                          "twofourfive485" 25
                          "2fourghsixptk" 26
                          "5fivezgfgcxbf3five" 55
                          "eighthtkk5" 85
                          "qjqpnfs812sevensbjlkzrzczdmsr" 87
                          "cpxtthree14" 34
                          "pljnzhchrrqvkncfnfive6four7dzqkfslm9" 59
                          "dlrczxpfxp1" 11
                          "sixsix35" 65
                          "twoxldv5rftbpfivevqtphhxvgzkhbg" 25
                          "zsjtsvjtlrsdsvqgfouronexhnbgpsl8" 48
                          "five813" 53
                          "53eightfourlseven5bvtmzfkqc6" 56
                          "51two8eightseven" 57
                          "frfshfjvlhgsjvmxbplkmsm1seven" 17})

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
    (is (= (filter-numbers "two") 22))))
    ;; this one is glitchy but we changed the approach
    ;;(is (= (filter-numbers "eighthree") 83))

(deftest filter-numbers-test
  (testing "Filter numbers - only first and last number"
    (is (= (filter-numbers "678973") 63))))

(deftest filter-numbers-string-test
  (testing "Filtering numbers from a string with \\n" 
    (is (= (filter-numbers-string test-input) [29 83 13 24 42 14 76]))))

(deftest sum-numbers-string-test
  (testing "Sum the numbers from a string with \\n"
    (is (= (sum-numbers-from-sorted test-input) 281))))

(deftest sum-numbers-from-sorted-test
  (testing "Sum the numbers from a string with \\n using the sorted array"
    (is (= (sum-numbers-from-sorted test-input) 281))
    (is (= (sum-numbers-from-sorted test-real-input) 816))))

(deftest get-only-numbers-in-string-test
  (testing "Filter number array to get only numbers that show up in the string"
    (is (= (get-only-numbers-in-string "twosixseventhree8") {"six" "6" "three" "3" "two" "2""seven" "7" "8" "8"}))
    (is (= (get-only-numbers-in-string "eighthree") {"eight" "8", "three" "3"}))
    (is (= (get-only-numbers-in-string "frfshfjvlhgsjvmxbplkmsm1seven") {"1" "1", "seven" "7"}))))

(deftest get-first-last-sorted-test
  (testing "Get first and last value from sorted map"
    (is (= (get-first-last-sorted "eighthree") 83))
    (is (= (get-first-last-sorted "oneight") 18))
    (is (= (get-first-last-sorted "twone") 21))
    (is (= (get-first-last-sorted "eightwo") 82))
    (is (= (get-first-last-sorted "eighthree") 83))
    (is (= (get-first-last-sorted "threeight") 38))
    (is (= (get-first-last-sorted "fiveight") 58))
    (is (= (get-first-last-sorted "sevenine") 79))
    (is (= (get-first-last-sorted "nineight") 98))
    (is (= (get-first-last-sorted "nineight9") 99))
    (is (= (get-first-last-sorted "frfshfjvlhgsjvmxbplkmsm1seven") 17))
    (is (= (get-first-last-sorted "5fivezgfgcxbf3five") 55))
    (is (= (get-first-last-sorted "kzqdfqbdztwoseven5twooneightf") 28))))

(deftest get-first-last-sorted-real-input-test
  (testing "Get first and last value from real input"
    (doseq [[k v] test-map-real-input] (is (= (get-first-last-sorted k) v)))))

(deftest sort-numbers-by-string-test
  (testing "Sort numbers in number array by the position where they appear in the string"
    (is (= (sort-numbers-by-string "eightwo3") {"eight" "8" "two" "2" "3" "3"}))
    (is (= (sort-numbers-by-string "zoneight234") {"one" "1" "eight" "8" "2" "2", "3" "3", "4" "4"}))))

(deftest repeated-numbers-test
  (testing "Returns which number is repeated test"
    (is (= (repeated-last-number "fiveoh3five" (last (vals (sort-numbers-by-string "fiveoh3five")))) "five"))
    (is (= (repeated-last-number "fiveoh3" (last (vals (sort-numbers-by-string "fiveoh3five")))) "3"))))

(deftest find-any-missing-last-number-test
  (testing "Checks if there's a repeated number that we didn't get yet test"
    (is (= (find-any-missing-last-number "fiveoh3"
                                         (last (keys (sort-numbers-by-string "fiveoh3")))) "3"))
    (is (= (find-any-missing-last-number "fiveoh3five"
                                         (last (keys (sort-numbers-by-string "fiveoh3five")))) "5"))))

(last (keys (sort-numbers-by-string "fiveoh3five")))
(find-any-missing-last-number "fiveoh3five" "3")

(deftest change-numbertext-numbers-test
  (testing "Turn number names into numbers"
    (is (= (change-numbertext-numbers "nine32fourh") "9324h"))
    (is (= (change-numbertext-numbers "eightwo3") "8wo3"))
    (is (= (change-numbertext-numbers "eightwosix3") "8wo63"))))

(deftest change-numbertext-string-test
  (testing "Turn number names into numbers from a string with \\n"
    (is (= (change-numbertext-string test-input) ["219" "8wo3" "abc123xyz" "x2ne34" "49872" "z1ight234" "7pqrst6teen"]))))

;; Opening the file and getting the answer :) 
(sum-numbers-from-sorted (slurp "input.txt"))
