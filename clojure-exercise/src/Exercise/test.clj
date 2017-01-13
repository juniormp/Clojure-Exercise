(ns test)


;; funcao sem nome
(fn [x] (+ x 3))

;; list (array)
(def lista [1 2 3 4])


;; set (conjunto)
(def conjunto #{"A" "B" "C"})
;; verifica se existe o elemento no conjunto, false nao existe, true existe
(contains? conjunto "A")
;; adiciona elementos ao conjunto
(conj conjunto "D")
;; remove elementos ao conjunto
(disj conjunto "A")

;; funcao multiplica numero por 2
(defn mult [x] (* x 2))

;; funcao map recebe outra funcao para fazer iteracao como se fose o for em java
(map mult lista)

;; funcao que verifica se um numero é par ou impar pelo resto da divisao, true par, false impar
(defn par [x] (= 0 (rem x 2)))

;; remove os elementos pares - é passado a funcao que detecta par + a lista
(remove par lista)

;; triplica numeros
(defn triplica [x] (* x 3))

;; fibonnacci
(defn fib[x]
  (if (= x 0) 0
  (if (= x 1) 1
  (+ (fib (- x 1)) (fib (- x 2))))))

;; listas
(def numeros [1, 2, 3, 4, 5])
(def carros [50000.0 60000.0])

;; primeira funcao verifica se e impar e a segunda remove elesmentos impares da lista
(defn impar? [x]
  (= 1 (rem x 2))
)
(remove impar? lista)

;; filtra numeros menores que 2 ou maiores que 4
(filter
  (fn [x] (or (< x 2) (> x 4))) lista 
)

;; ler entrada
(defn ler-letra! [] (read-line))
;; converte string para inteiro e multiplica por 7
(defn converte-para-inteiro []
  (* 7 (Integer/parseInt (ler-letra!))))

;; Utiliza o método contaisn do JAVA pois clojure roda na JVM
(.contains lista 1)
 
