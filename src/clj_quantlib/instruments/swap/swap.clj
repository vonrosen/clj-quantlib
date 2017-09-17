(ns clj-quantlib.instuments.swap
  (:require clj-quantlib.instruments :refer [IInstrument])
  (:import (com.github.vonrosen.quantlib VanillaSwap
                                         _VanillaSwap.Type)))

(def ^{:doc "Map of vanilla swap type keywords into native java _VanillaSwap.Type objects."}
     keywords-to-vanilla-swap-types
  {:payer (_VanillaSwap.Type/Payer)
   :receiver (_VanillaSwap.Type/Receiver)})

VanillaSwap spot5YearSwap = new VanillaSwap(
				swapType,
				nominal,
				fixedSchedule,
				fixedRate,
				fixedLegDayCounter,
				floatSchedule,
				euriborIndex,
				spread,
				floatingLegDayCounter);

(defrecord vanilla-swap-1 [type nominal fixed-schedule fixed-rate fixed-day-count float-schedule ibor-index spread floating-day-count pricing-engine]
  IInstrument
  (to-java [this]
    (new VanillaSwap (type keywords-to-vanilla-swap-types)
         nominal
         (to-java fixed-schedule)
         
         
         )  
    
    ))

(defn vanilla-swap
  [type nominal fixed-schedule fixed-rate fixed-day-count float-schedule ibor-index spread floating-day-count pricing-engine]
  (->vanilla-swap-1 (keyword type) nominal fixed-schedule fixed-rate fixed-day-count float-schedule ibor-index spread floating-day-count pricing-engine))