(ns CookBookClojure.06.2_concurrency_agents)

; creating
(def first-agent (agent 0)) 

; updating
(send first-agent inc) 

(def makoto-agent (agent {:name "Makoto" :location [100 200]})) 

(defn move [a dx dy t] 
  (println "moving takes " t "msecs") 
  (Thread/sleep t) 
  (assoc a :location 
         [(+ ((:location a) 0) dx) 
          (+ ((:location a) 1) dy)])) 

(do 
  (send makoto-agent move 10 20 1000) 
  (println makoto-agent) 
  (await makoto-agent) 
  (println makoto-agent)) 