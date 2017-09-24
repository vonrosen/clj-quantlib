(ns clj-quantlib.time.dategenerationrule
  (:import (com.github.vonrosen.quantlib DateGeneration)))

(def ^{:doc "Map of time keywords into native java DateGeneration.Rule objects."}
     keywords-to-dategenerationrule
  {:backward (DateGeneration/Backward)
   :forward (DateGeneration/Forward)
   :zero (DateGeneration/Zero)
   :thirdwednesday (DateGeneration/ThirdWednesday)
   :twentieth (DateGeneration/Twentieth)
   :twentiethimm (DateGeneration/TwentiethIMM)
   :oldcds (DateGeneration/OldCDS)
   :cds (DateGeneration/CDS)
   :cds2016 (DateGeneration/CDS2015)})