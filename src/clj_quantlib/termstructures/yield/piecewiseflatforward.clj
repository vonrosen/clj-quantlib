(ns clj-quantlib.termstructures.yield.piecewiseflatforward)

(defrecord piecewiseflatforward-1 [settlement-date instruments day-counter])

(defn piecewiseflatforward 
  ([settlement-date instruments day-counter]
    (->piecewiseflatforward-1 settlement-date instruments day-counter)))