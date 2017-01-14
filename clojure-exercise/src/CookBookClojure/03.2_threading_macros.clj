(ns CookBookClojure.03.2_threading_macros)

; -> (first paramter)

(-> 2 (- 1)) 

(-> 2  (+ 1) str) 

; ->> (second parameter

(->> 2 (- 1))

(->> [1 2 3] (map inc))

(->> [1 2 3] (map inc) (into [])) 

; (cond->  ) keeps on going until the end of the conditions

 (let [speed 110 count 0] 
         (cond-> count 
           (>= speed 130) inc  
           (>= speed 100) inc 
           (>= speed 80) inc 
           (>= speed 50) inc)) 
 
 ; (cond->> )
 
 
