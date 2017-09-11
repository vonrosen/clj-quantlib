(ns clj-quantlib.indexes.interestrateindex
  (:require [clj-quantlib.time.period :refer [period]]))

(defrecord euribor-1 [period])
(defrecord euribor-2 [period term-structure])

(defn euribor6M []
  (->euribor-1 (period :months 6)))

(defn euribor6M [term-structure]
  (->euribor-2 (period :months 6) term-structure))