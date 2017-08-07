(ns clj-quantlib.termstructures.ratehelpers.yield
  (:import org.vonrosen.quantlib 
           DepositRateHelper
           SwapRateHelper))

(defn deposit-rate-helper [rate period fixing-days convention end-of-month day-counter]
  (DepositRateHelper. rate period fixing-days convention end-of-month day-counter))

(defn swap-rate-helper [rate tenor fixed-frequency fixed-convention fixed-day-count index]
  (SwapRateHelper. rate tenor fixed-frequency fixed-convention fixed-day-count index))