(ns CookBookClojure.06.1_concurrency_ref)

; Software Transactional Memory (STM) provides transactional accesses to multiple resources on memory. 

(def makoto-account (ref {:name "Makoto Hashimoto" :amount 1000})) 

(def nico-account (ref {:name "Nicolas Modrzyk" :amount 2000})) 

; updating refs

(defn transfer! [from to amount] 
  (dosync 
   (println "transfer money from " (:name @from) " to " (:name @to) " amount = " amount " begins") 
   (alter from assoc :amount (- (:amount @from) amount)) 
   (Thread/sleep 500) 
   (alter to assoc :amount (+ (:amount @to) amount)) 
   (println "Now, " (:name @from) " amount is  " (:amount @from) " and " (:name @to) " amount is " (:amount @to)))) 

;(do 
;    (future 
;       (transfer! makoto-account nico-account 200)) 
;    (future 
;      (transfer!  makoto-account nico-account 300))) 



; ensure
; The ensure function protects refs from trying to update while a preceding update is in progress. 

(defn ensure-transfer! [from to amount] 
  (dosync 
   (ensure from) 
   (println "transfer money from " (:name @from) 
            " to " (:name @to) " amount = " amount " begins") 
   (alter from assoc :amount (- (:amount @from) amount)) 
   (Thread/sleep 500) 
   (alter to assoc :amount (+ (:amount @to) amount)) 
   (println "Now, " (:name @from) " amount is  " (:amount @from) 
            " and " (:name @to) " amount is " (:amount @to))))

;(do 
;    (future 
;       (transfer! makoto-account nico-account 200)) 
;    (future 
;      (transfer!  makoto-account nico-account 300))) 


; Watcher traces modifications of refs. 

(defn add-watcher [ref] 
  (add-watch ref :watcher 
             (fn [_ _ old-state new-state] 
               (prn "---- ref changed --- " old-state " => " new-state)))) 

(add-watcher makoto-account) 
(add-watcher nico-account) 

(defn refined-transfer! [from to amount] 
  (dosync 
   (ensure from) 
   (if (<=  (- (:amount @from) amount) 0) 
     (throw (Exception. "insufficient amount"))) 
   (alter from assoc :amount (- (:amount @from) amount)) 
   (Thread/sleep 500) 
   (alter to assoc :amount (+ (:amount @to) amount)))) 

(dosync 
  (ref-set makoto-account {:name "Makoto Hashimoto" :amount 1000}) 
  (ref-set nico-account {:name "Nicolas Modrzyk" :amount 2000})    
  ) 

; (refined-transfer! makoto-account nico-account 1500)  Throw Expection insufficient amount


; Using commute - when the order of updates does not matter. 

(defn alter-add! [var val] 
  (dosync 
   (Thread/sleep 500) 
   (alter var  (partial + val)))) 

;  Elapsed time: 2504.52562 msecs
(do 
  (def v1 (ref 10)) 
  (time 
   (doseq 
       [x [ 
           (future (alter-add! v1 10)) 
           (future (alter-add! v1 10)) 
           (future (alter-add! v1 10)) 
           (future (alter-add! v1 10)) 
           (future (alter-add! v1 10)) 
           ]] 
     @x)) 
  (println @v1) 
  ) 

(defn commute-add! [var val] 
  (dosync 
   (Thread/sleep 500) 
   (commute var  (partial + val)))) 

(do 
  (def v1 (ref 10)) 
  (time 
   (doseq 
       [x [(future (commute-add! v1 10)) 
            (future (commute-add! v1 10)) 
            (future (commute-add! v1 10)) 
            (future (commute-add! v1 10)) 
            (future (commute-add! v1 10))]] 
     @x)) 
  (println @v1) 
  ) 
