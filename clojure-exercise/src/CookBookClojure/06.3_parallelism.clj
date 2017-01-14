(ns CookBookClojure.06_3_parallelism)

; promise delays it's execution until deliver sets it value.

(def x (promise)) 
(def y (promise)) 
(def z (promise)) 

(future 
  (do (deliver z (+ @x @y)) 
      (println "z value : " @z))) 

(realized? z) 
(deliver x 1) 
(deliver y 1) 


; Assuming that multiple products are ready and a shipment instruction has occurred.

(defrecord order [name price qty]) 

(defn merge-products [m1 m2] 
  {:total-price 
   (+ (* (.price x) (.qty x)) (* (.price y) (.qty y)))}  
  [m1 m2]) 

(defn ship-products [x y z] 
  (deliver z (merge-products @x @y)) 
  (println "We can ship products  " @z)) 

(defn deliver-product [p name price] 
  (deliver p [name price])) 

(def product-a (promise)) 
(def product-b (promise)) 
(def shipping-ab (promise)) 

(future (ship-products product-a product-b shipping-ab)) 

(deliver product-a (->Order "book" 10.1 5)) 
(deliver product-b (->Order "pencil" 2.1 10)) 



; pmap, pcalls, and pvalues




