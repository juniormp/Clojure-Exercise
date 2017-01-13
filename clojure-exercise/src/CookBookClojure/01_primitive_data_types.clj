(ns CookBookClojure.01-primitive-data-types)

(float (/ 10 3)) 

(double (/ 10 3)) 

; quotient
(quot 10 3) 

; remainder
(rem 10 3) 

; BigDecimal
(bigdec (/ 10 2)) 

; BigInteger
(bigint (/ 10 2)) 

; The following syntax is how to call Java's member methods from Clojure:
(.concat "Hello " "world !") 
(str "Hello " "world !" " Clojure") 
(.length "Hello world !") 