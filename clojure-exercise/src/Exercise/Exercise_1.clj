(ns Trainning.Exercise_1)

; The sell rate for the English pound was 12.7775 SEK 
; on the 20th of October 2008. How many  pounds did one get for 1000 SEK that day?


(defn pounds [x] (/ x 12.7775 ))

; In some countries people use the Fahrenheit temperature scale. 0° Celsius (C) corresponds to 32° Fahrenheit (F), 
; and an increase of 5° C corresponds to an increase of 9° F. How many Fahrenheit degrees is 28° C?

(defn temperature [x] (+ (/ (* x 9) 5) 32))

; A shop sells potatoes for 3.50 SEK / Kg. To stimulates large sales,
; the shop offers a discount of 3 SEK / Kg for the quantity exceeding 10 Kg.
; We want to define the function that calculates the price.

(defn potatoes[k] 
  (if (>= k 10)
   (- (* k 3.50)(* (- k 10) 3))
   (* k 3.50)))


