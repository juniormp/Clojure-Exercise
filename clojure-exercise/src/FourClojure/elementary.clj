(ns FourClojure.elementary)

; Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
(defn to-upper-case [word]
  (.toUpperCase word))

(def mapa 
  (map #(+ % 5) '(1 2 3 4 5)))

(def filtro
  (filter #(> % 5) '(1 2 3 4 5 6 7)))

(def reduce1
  (reduce + [1 2 3 4 5]))

(def reduce2
  (reduce * 1 [2 3]))

; (contains? {:a nil :b 2} :a)

