(ns clj-quantlib.examples.swap.swapvaluation
  (:require 
    [clj-quantlib.termstructures.yield.ratehelpers :refer 
     [deposit-rate-helper swap-rate-helper]]
    [clj-quantlib.time.period :refer [period]]
    [clj-quantlib.time.daycounters :refer [day-counter]]
    [clj-quantlib.time.calendar :refer [date-adjusted date-add]]
    [clj-quantlib.indexes.interestrateindex :refer [euribor6M]]
    [clj-quantlib.pricingengines.swap.swapengines :refer [discounting-swap-engine]]
    [clj-quantlib.instuments.swap.vanillaswap :refer [vanilla-swap]]
    [clj-quantlib.termstructures.yield.piecewiseflatforward :refer [piecewise-flat-forward]]))

(def fixing-days 2)

(def depo-rate-helpers (list 
                         (deposit-rate-helper 
                           0.0382 
                           (period :weeks 1) fixing-days :modifiedfollowing true (day-counter :actual360))
                         (deposit-rate-helper 
                           0.0372 
                           (period :months 1) fixing-days :modifiedfollowing true (day-counter :actual360))
                         (deposit-rate-helper 
                           0.0363 
                           (period :months 3) fixing-days :modifiedfollowing true (day-counter :actual360))
                         (deposit-rate-helper 
                           0.0353 
                           (period :months 6) fixing-days :modifiedfollowing true (day-counter :actual360))
                         (deposit-rate-helper 
                           0.0348 
                           (period :months 9) fixing-days :modifiedfollowing true (day-counter :actual360))
                         (deposit-rate-helper 
                           0.0345 
                           (period :years 1) fixing-days :modifiedfollowing true (day-counter :actual360))))

(def swap-rate-helpers (list 
                         (swap-rate-helper 
                           0.037125
                           (period :years 2)
                           :annual
                           :unadjusted
                           (day-counter :thirty360 :european)
                           (ibor-index :6Month))
                         (swap-rate-helper 
                          0.0398
                          (period :years 3)
                          :annual
                          :unadjusted
                          (day-counter :thirty360 :european)
                          (euribor6M))
                         (swap-rate-helper 
                          0.0443
                          (period :years 5)
                          :annual
                          :unadjusted
                          (day-counter :thirty360 :european)
                          (euribor6M))
                         (swap-rate-helper 
                          0.05165
                          (period :years 10)
                          :annual
                          :unadjusted
                          (day-counter :thirty360 :european)
                          (euribor6M))
                         (swap-rate-helper 
                          0.055175
                          (period :years 15)
                          :annual
                          :unadjusted
                          (day-counter :thirty360 :european)
                          (euribor6M))))

(defn swap-valuation []
  (let [settlement-date (date-adjusted 22 :september 2004)
        maturity-date (date-add settlement-date (period :years 5))
        fixed-schedule (schedule 
                         settlement-date
                         maturity-date
                         (period :annual)
                         :unadjusted
                         :unadjusted
                         :forward
                         false)
        floating-schedule (schedule 
                            settlement-date
                            maturity-date
                            :semiannual
                            :modifiedfollowing
                            :modifiedfollowing
                            :forward
                            false)
        depo-swap-instruments (concat depo-rate-helpers swap-rate-helpers)
        term-structure (piecewise-flat-forward 
                         settlment-date 
                         depo-swap-instruments 
                         (day-counter :actualactual :isda))        
        floating-index (euribor6M term-structure)
        swap-engine (discounting-swap-engine term-structure)        
        swap (vanilla-swap 
               :payer
               1000000.0
               fixed-schedule
               0.04
               (day-counter :thirty360 :european)
               floating-schedule
               floating-index
               0.0
               (day-counter :thirty360)
               swap-engine)]    
    (prn (npv swap))))
