(ns clj-quantlib.indexes.index)

(defprotocol Index
  (to-java [this]))