(ns CookBookClojure.02_collections)

; 4 Types - Lists, Vectors, Maps, Sets

(def biography-of-konan-doyle 
  {:name "Arthur Ignatius Conan Doyle" 
   :born "22-May-1859" 
   :died "7-July-1930" 
   :occupation ["novelist" "short story writer" "poet" "physician"] 
   :nationality "scotish" 
   :citizenship "United Kingdom" 
   :genre ["Detective fiction", "fantasy", "science fiction", "historical novels", "non-fiction"] 
   :notable-works ["Stories of Sherlock Holmes" "The Lost World"] 
   :spouse ["Louisa Hawkins" "Jean Leckie"] 
   :no-of-children 5 
   } 
  )

; (get-in biography-of-konan-doyle [:genre 2]) 
   ;;=> "science fiction" 
   
   (assoc-in {:a {:b 1 :c 2} :d 3} [:a :c] 1) 
;;=> {:a {:b 1, :c 1}, :d 3} 
(assoc-in {:a {:b 1 :c 2} :d 3} [:a :d] 1) 
;;=> {:a {:b 1, :c 2, :d 1}, :d 3} 