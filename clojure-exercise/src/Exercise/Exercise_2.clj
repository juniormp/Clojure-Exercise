(ns Trainning.Exercise_2)

; Example recur with loop

(defn contagem [x]
  (if (zero? x)
    :blastoff! 
    (do (println x) 
      (recur (dec x)))))

(defn contar [x]
  (loop [iterador 1]
    (if (>= iterador x)
      (println iterador)
      (do
        (println iterador)
        (recur (inc iterador))))))


; Define a function which computes the sum of the squares of the numbers from 1 to n.

(defn squares [n]
  (if (= n 1)
    (println "1 * 1 = 1")
    (do (println n "*" n "=" (* n n))
      (recur (dec n)))))

; The Towers of Hanoi is an ancient puzzle, consisting of a collection of rings of different sizes,
;and three posts mounted on a base. At the beginning all the rings are on the left-most post as shown,
;and the goal is to move them all to the rightmost post, by moving one ring at a time from one post to another. 
;But, at no time may a larger ring be placed on top of a smaller one!

; Revisar



;  Fibonacci Numbers

(defn fibonacci [x]
  (loop [a 1 b 1 numero 2]
    (if (= numero x)
      b
      (recur b (+ a b) (inc numero)))))


; Think of an whole number greater than one. If its even, divide it by two, 
; otherwise multiply it by three and add one. Stop if the resulting number is one, 
; otherwise repeat the procedure.


(defn teste [n]
    (if (= n 1)
      (println "Result: " n)
      (do
        (println "Result: " n)
        (if (= 0 (mod n 2))
          (do 
            (println n "/ 2 =" (/ n 2))
            (recur (/ n 2)))
          (do
            (println n "* 3 + 1 =" (+ (* n 3) 1))
            (recur (+ (* n 3) 1)))))))

; A prime number p has only two factors, 1 and p itself. 
; A composite number has more than two factors. Define a function
; which returns the smallest factor of n larger than one. 

(defn factor [n]
  (loop [iterador 2]
    (if (= (mod n iterador) 0)
      (println "Menor divisivel" iterador)
      (recur (inc iterador)))))

; Define a function that replicates a given word n times

(defn palavra [t p]
  (loop [iterator 0]
    (if (>= iterator t)
      (println "Finalizou")
      (do
        (println iterator "vez" p)
        (recur (inc iterator))))))

(defn repetir [p t]
  (repeat t p))

; which multiplies together all the elements of a list.

(defn lista [l]
  (* 2 l))


