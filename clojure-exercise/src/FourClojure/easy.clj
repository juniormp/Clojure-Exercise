(ns FourClojure.easy)

; 19. Sequence - last element
(= 5 (last [1 2 3 4 5]))
(= 3 (last '(5 4 3)))
(= "d" (last ["b" "c" "d"]))

; 20. Sequence - second to last element
(= 4 (second (reverse (rest (list 1 2 3 4 5)))))
(= "b" (second (reverse (rest ["a" "b" "c"]))))
(= [1 2] (#(first (rest (reverse %))) [[1 2] [3 4]]))
