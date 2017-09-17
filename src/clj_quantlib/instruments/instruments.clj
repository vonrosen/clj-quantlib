(ns clj-quantlib.instruments)

(defprotocol IInstrument
  (to-java [this]))

(defn npv [engine instrument]
  
  
  )