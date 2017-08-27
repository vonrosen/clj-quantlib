(ns clj-quantlib.time.daycounters)

(defrecord daycounter-1 [type])
(defrecord daycounter-2 [type convention])
(defrecord daycounter-3 [type convention schedule])

(defn daycounter 
  ([type]
    (->daycounter-1 (keyword type)))
  ([type convention]
    (->daycounter-2 (keyword type) (keyword convention)))
  ([type convention schedule]
    (->daycounter-3 (keyword type) (keyword convention) schedule)))