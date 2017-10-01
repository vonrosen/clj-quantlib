(ns clj-quantlib.pricingengines.swap.swapengines
  (:import (com.github.vonrosen.quantlib RelinkableYieldTermStructureHandle)))

(defprotocol Engine
  (to-java [this]))

(defrecord discounting-swap-engine-1 [discount-curve settlement-date npv-date]
  Engine
  (to-java [this]
    #_todo))
(defrecord discounting-swap-engine-2 [discount-curve settlement-date]
  Engine
  (to-java [this]
    #_todo))
(defrecord discounting-swap-engine-3 [discount-curve]
  Engine
  (to-java [this]
    (new DiscountingSwapEngine
         (doto (RelinkableYieldTermStructureHandle.) (.linkTo (to-java discount-curve))))))
(defrecord discounting-swap-engine-4 [discount-curve include-settlement-date-flows settlement-date npv-date]
  Engine
  (to-java [this]
    #_todo))
(defrecord discounting-swap-engine-5 [discount-curve include-settlement-date-flows settlement-date]
  Engine
  (to-java [this]
    #_todo))
(defrecord discounting-swap-engine-6 [discount-curve include-settlement-date-flows]
  Engine
  (to-java [this]
    #_todo))

(defn discounting-swap-engine
  ([discount-curve settlement-date npv-date]
    (->discounting-swap-engine-1 discount-curve settlement-date npv-date))
  ([discount-curve settlement-date]
    (->discounting-swap-engine-2 discount-curve settlement-date))
  ([discount-curve]
    (->discounting-swap-engine-3 discount-curve))
  ([discount-curve include-settlement-date-flows settlement-date npv-date]
    (->discounting-swap-engine-4 discount-curve include-settlement-date-flows settlement-date npv-date))
  ([discount-curve include-settlement-date-flows settlement-date]
    (->discounting-swap-engine-5 discount-curve include-settlement-date-flows settlement-date))
  ([discount-curve include-settlement-date-flows]
    (->discounting-swap-engine-6 discount-curve include-settlement-date-flows)))