(ns exercises)

(defn fib [x]
  (loop [a 1 b 1 numero 2]
    (if
      (= numero x) b
      (recur b (+ a b) (inc numero)))))


(defn sum [n]
  (loop [iterator 1 sum 0]
    (if (> iterator n) sum
      (recur (inc iterator) (+ sum iterator)))))