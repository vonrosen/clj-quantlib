(ns clj-quantlib.instruments)

(defprotocol IInstrument
  (to-java [this])
  (npv [this]))