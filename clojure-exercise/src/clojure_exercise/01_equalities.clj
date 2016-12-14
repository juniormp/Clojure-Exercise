(ns clojure-exercise.core)

;; "We shall contemplate truth by testing reality, via equality"
;; (= __ true)
;; (= true true)

;; "To understand reality, we must compare our expectations against reality"
;;  (= __ (+ 1 1))
;;  (= 2 (+ 1 1))

;; "You can test equality of many things"
;;  (= (+ 3 4) 7 (+ 2 __))
;;  (= (+ 3 4) 7 (+ 2 5))

;; "Some things may appear different, but be the same"
;; (= __ (= 2 2/1))
;; (= true (= 2 2/1))

;; "You cannot generally float to heavens of integers"
;; (= __ (= 2 2.0))
;; (= false (= 2 2.0))

;; "But a looser equality is also possible"
;; (= __ (== 2.0 2))
;; (= true (== 2.0 2))

;; "Something is not equal to nothing"
;; (= __ (not (= 1 nil)))
;; (= true (not (= 1 nil)))

;; "Strings, and keywords, and symbols: oh my!"
;; (= __ (= "hello" :hello 'hello))
;;  (= false (= "hello" :hello 'hello))

;; "Make a keyword with your keyboard"
;; (= :hello (keyword __))
;; (= :hello (keyword :hello))

;; "Symbolism is all around us"
;; (= 'hello (symbol __))
;; (= 'hello (symbol 'hello))

;; "What could be equivalent to nothing?"
;; (= __ nil)
;; (= nil nil)

;; "When things cannot be equal, they must be different"
;; (not= :fill-in-the-blank __)
;; (not= :fill-in-the-blank :different)

