(ns CookBookClojure.03_destructuring_techniques)

; Sequential destructuring is for extracting desired elements from sequence collections.

(let [[x y z] [1 2 3] [a b c] ["a" "b" "c"]] [x y z a b c])

(let [[x y & z] [1 2 3 4]] [x y z])

(let [[x _ z] [1 2 3]] [x z])

; Map destructuring extracts desired values from maps. 

(let [{x :x y :y z :z} {:x 1 :y 2 :z 3}] [x y z]) ; Full demostration

(let [{:keys [x y z]} {:x 1 :y 2 :z 3}] [x y z]) ; Shortcurt demostration

(let [{:strs [x y z]} {"x" 1 "y" 2 "z" 3}] [x y z]) ; For Strings

(let [{:syms [x y z]} {'x 1 'y 2  'z  3}] [x y z]) ; For symbols

(let [{:keys [x y z] :or {x 0 y 0 z 0}} {:x 1} ] [x y z]) ; Specify the default values

(let [{:keys [x y z] :or {x 0 y 0 z 0} :as all} {:x 1 :a 2 :b 3} ] [x y z all]) ; Using the :as keyword, the followed variable binds to the map itself.

(let 
    [{x :x y :y {a :a b :b} :z} 
     {:x 1 :y 2 :z {:a 3 :b 4}} 
     ] 
  [x y a b])  ; Map-destructuring a nested-map

(let 
    [{:keys [x y] {:keys [a b]} :z} 
     {:x 1 :y 2 :z {:a 3 :b 4}} 
     ] 
  [x y a b])  ; Map-destructuring a nested-map (shortcut)


; Comparing sequential destructuring technique in a function with one not using

(defn func1 [[x y z]] 
  (+ x y z)) ; using

(defn func2 [col] 
  (+ (first col) (second col) (nth col 2))) ; not using


; Comparing map destructuring technique in a function with one not using

(defn func3 [{:keys [x y z]}] 
  (+ x y z)) ; using

(defn func4 [col] 
  (+ (:x col) (:y col) (:z col))) ; not using 


