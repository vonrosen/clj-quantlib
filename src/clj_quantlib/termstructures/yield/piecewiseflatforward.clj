(ns clj-quantlib.termstructures.yield.piecewiseflatforward
  (:import (com.github.vonrosen.quantlib PiecewiseFlatForward
                                         RateHelperVector)))

(defprotocol YieldTermStructure
  (to-java [this]))

(defrecord piecewiseflatforward-1 [settlement-date instruments day-counter]
  YieldTermStructure
  (to-java [this]
    (new PiecewiseFlatForward
         (to-java settlement-date)
         (doto (RateHelperVector.) (dotimes [instrument instruments] (.add (to-java instruments))))
         day-counter)))

(defn piecewiseflatforward 
  ([settlement-date instruments day-counter]
    (->piecewiseflatforward-1 settlement-date instruments day-counter)))