(ns clj-quantlib.instruments.instrument)

(defprotocol IInstrument
  (to-java [this])
  (npv [this]))