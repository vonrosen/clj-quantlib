(ns clj-quantlib.termstructures.yield.ratehelpers
  (:require clj-quantlib.time.businessdayconvention :refer [keywords-to-businessdayconvention])
  (:import (com.github.vonrosen.quantlib DepositRateHelper)))

(defprotocol RateHelper
  (to-java [this]))


(deposit-rate-helper 
                           0.0382 
                           (period :weeks 1) 
                           fixing-days 
                           :modifiedfollowing 
                           true 
                           (day-counter :actual360))

public DepositRateHelper(double rate, Period tenor, long fixingDays, Calendar calendar, BusinessDayConvention convention, boolean endOfMonth, DayCounter dayCounter) {



(defrecord deposit-rate-helper-1 [rate period fixing-days convention end-of-month day-counter]
  RateHelper
  (to-java [this]
    (new DepositRateHelper
         rate
         (to-java period)
         fixing-days
         (convention keywords-to-businessdayconvention)
         end-of-month
         (to-java day-counter)
         
         
         
         )))
(defrecord deposit-rate-helper-2 [rate, ibor-index]
  RateHelper
  (to-java [this]
    #_todo))
(defrecord fra-rate-helper-1 [rate months-to-start months-to-end fixing-days convention end-of-month day-counter])
(defrecord fra-rate-helper-2 [rate months-to-start ibor-index])
(defrecord swap-rate-helper-1 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days pillar custom-pillar-date])
(defrecord swap-rate-helper-2 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days pillar])
(defrecord swap-rate-helper-3 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days])
(defrecord swap-rate-helper-4 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve])
(defrecord swap-rate-helper-5 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start])
(defrecord swap-rate-helper-6 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread])
(defrecord swap-rate-helper-7 [rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index])
(defrecord swap-rate-helper-8 [rate swap-index spread fwd-start discounting-curve pillar custom-pillar-date])
(defrecord swap-rate-helper-9 [rate swap-index spread fwd-start discounting-curve pillar])
(defrecord swap-rate-helper-10 [rate swap-index spread fwd-start discounting-curve])
(defrecord swap-rate-helper-10 [rate swap-index spread fwd-start])
(defrecord swap-rate-helper-11 [rate swap-index spread])
(defrecord swap-rate-helper-12 [rate swap-index])

(defn deposit-rate-helper 
  ([rate period fixing-days convention end-of-month day-counter]
    (->deposit-rate-helper-1 rate period fixing-days convention end-of-month day-counter))
  ([rate ibor-index]
    (->deposit-rate-helper-2 rate ibor-index)))

(defn fra-rate-helper
  ([rate months-to-start months-to-end fixing-days convention end-of-month day-counter]
    (->fra-rate-helper-1 rate months-to-start months-to-end fixing-days convention end-of-month day-counter))
  ([rate ibor-index]
    (->fra-rate-helper-2 rate ibor-index)))

(defn swap-rate-helper 
  ([rate tenor fixed-frequency fixed-convention 
    fixed-day-count ibor-index spread fwd-start 
    discounting-curve settlement-days pillar custom-pillar-date]
    (->swap-rate-helper-1 rate tenor fixed-frequency fixed-convention 
                        fixed-day-count ibor-index spread fwd-start 
                        discounting-curve settlement-days pillar custom-pillar-date))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days pillar]
    (->swap-rate-helper-2 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days pillar))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days]
    (->swap-rate-helper-3 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve settlement-days))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve]
    (->swap-rate-helper-4 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start 
                               discounting-curve))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start]
    (->swap-rate-helper-5 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread fwd-start))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread]
    (->swap-rate-helper-6 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index spread))
  ([rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index]
    (->swap-rate-helper-7 rate tenor fixed-frequency fixed-convention 
                               fixed-day-count ibor-index))
  ([rate swap-index spread fwd-start discounting-curve pillar custom-pillar-date]
    (->swap-rate-helper-8 rate swap-index spread fwd-start discounting-curve pillar custom-pillar-date))
  ([rate swap-index spread fwd-start discounting-curve pillar]
    (->swap-rate-helper-9 rate swap-index spread fwd-start discounting-curve pillar))
  ([rate swap-index spread fwd-start discounting-curve]
    (->swap-rate-helper-10 rate swap-index spread fwd-start discounting-curve))
  ([rate swap-index spread fwd-start]
    (->swap-rate-helper-11 rate swap-index spread fwd-start))
  ([rate swap-index spread]
    (->swap-rate-helper-12 rate swap-index spread))
  ([rate swap-index]
    (->swap-rate-helper-13 rate swap-index)))