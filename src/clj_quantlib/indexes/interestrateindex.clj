(ns clj-quantlib.indexes.interestrateindex
  (:require [clj-quantlib.time.period :refer [period]
             clj-quantlib.indexes.index :refer [Index]])
  (:import (com.github.vonrosen.quantlib Euribor10M
                                         Euribor11M
                                         Euribor1M
                                         Euribor1Y
                                         Euribor2M
                                         Euribor2W
                                         Euribor3M
                                         Euribor3W
                                         Euribor4M
                                         Euribor5M
                                         Euribor6M
                                         Euribor7M
                                         Euribor8M
                                         Euribor9M)))

(def ^{:doc "Map of periods into native java Euribor objects of the
corresponding time period."}
     period-to-euribor
  {(period :months 10) '(new Euribor10M)
   (period :months 11) '(new Euribor11M)
   (period :months 1) '(new Euribor1M)
   (period :years 1) '(new Euribor1Y)
   (period :months 2) '(new Euribor2M)
   (period :weeks 2) '(new Euribor2W)
   (period :months 3) '(new Euribor3M)
   (period :weeks 1) '(new Euribor3W)
   (period :months 4) '(new Euribor4M)
   (period :months 5) '(new Euribor5M)
   (period :months 6) '(new Euribor6M)
   (period :months 7) '(new Euribor7M)
   (period :months 8) '(new Euribor8M)
   (period :months 9) '(new Euribor9M)})

(defn new-java-euribor
  ([period]
    (eval (get period-to-euribor period)))
  ([period term-structure]
    (eval 
      (apply list (conj 
                    (vec (get period-to-euribor period)) 
                    '(new YieldTermStructureHandle (to-java term-structure)))))))

(defrecord euribor-1 [period]
  Index
  (to-java [this]
    (new-java-euribor period)))
(defrecord euribor-2 [period term-structure]
  (to-java [this]
    (new-java-euribor period term-structure)))

(defn euribor6M []
  (->euribor-1 (period :months 6)))

(defn euribor6M [term-structure]
  (->euribor-2 (period :months 6) term-structure))