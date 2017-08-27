(ns clj-quantlib.time.period)

(defrecord period-1 [time-unit units])
(defrecord period-2 [frequency])

(defn period 
  ([n units]
    (->period-1 (keyword n) units))
  ([frequency]
    (->period-2 (keyword frequency))))