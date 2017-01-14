(ns CookBookClojure.04_functional_programming_style)

; Functions taking functions as their arguments

(map inc [1 2 3 4 5])

(take 10 (map + (range) (range) (range) (range)(range))) 

(reduce + [1 2 3 4 5]) ; (+ (+ (+ (+ 1 2) 3) 4) 5) 

(apply * [1 2 3 4 5]) 

(apply - 1 2 3 [4 5]) 

(apply str ["Clojure" " " "programming" " " "cookbook"]) 

; Anonymus function

(map (fn [x] (+ x 2)) [1 2 3 4 5]) 

(reduce + 0 (map (fn [x] (+ x 2)) [1 2 3 4 5]))

((fn [x y & rest] (apply * x y rest)) 1 2 3 4 5) 

(map #(+ % 2) [1 2 3 4 5]) 

(#(+ % %2 %3) 1 2 3) 

; Macro

; defn is a macro using the def and fn special forms
(defn add2 [x] (+ x 2)) ; is equal -> (def my-add2 (fn [x] (+ x 2)))  


; Functions returning functions

(map (constantly 0) [1 2 3 4 5]) 

(def not-empty? 
  (complement empty?))

; (not-empty? [])
; (not-empty? [1 2 3]) 

(set (take 15 (repeatedly #(rand-int 30)))) 

(filter (partial < 10) [1 21 34 12 2]) 

(map (comp - inc) [ 1 2 3 4 5]) 

((every-pred odd? #(< % 12)  #(> % 2))  3  5 7) 

(filter (every-pred odd? #(< % 12)  #(> % 2)) [1 2 3 4 5]) 

