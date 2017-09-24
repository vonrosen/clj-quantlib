(ns clj-quantlib.time.daycounters
  (:import (com.github.vonrosen.quantlib Actual360
                                         Actual365Fixed
                                         Actual365NoLeap
                                         ActualActual
                                         Business252
                                         OneDayCounter
                                         SimpleDayCounter
                                         Thirty360)))

(def ^{:doc "Map of keywords into native java no-arg constructor DayCounter objects."}
     keyword-to-daycounters
  {:actual360 (new Actual360)
   :actual365fixed (new Actual365Fixed)
   :actual365noleap (new Actual365NoLeap)
   :actualactual (new ActualActual)
   :business252 (new Business252)
   :onedaycounter (new OneDayCounter)
   :simpledaycounter (new SimpleDayCounter)
   :thirty360 (new Thirty360)})

(def ^{:doc "Map of keywords into native java ActualActual Conventions."}
     keyword-to-daycounters-with-convention
  {:isma (ActualActual/ISMA)
   :bond (ActualActual/Bond)
   :isda (ActualActual/ISDA)
   :historical (ActualActual/Historical)
   :actual365 (ActualActual/Actual365)
   :afb (ActualActual/AFB)
   :euro (ActualActual/Euro)})

(->> (ActualActual/Euro)
  (new ActualActual))

(def ^{:doc "Map of keywords into native java DayCounter objects with Conventions."}
     keyword-to-daycounters-with-convention
  {:actualactual  
   :business252 (TimeUnit/Hours)
   :onedaycounter  (TimeUnit/Minutes)
   :simpledaycounter (TimeUnit/Seconds)
   :thirty360 (TimeUnit/Milliseconds)})

(defprotocol DayCounter
  (to-java [this]))

(defrecord daycounter-1 [type]
  DayCounter
  (to-java [this]
    (type keyword-to-daycounters)))
(defrecord daycounter-2 [type convention]
  DayCounter
  (to-java [this]
    (->> (convention keyword-to-daycounters-with-convention))
     (type keyword-to-daycounters) ))
(defrecord daycounter-3 [type convention schedule]
  DayCounter
  (to-java [this]
    #_todo))

(defn daycounter 
  ([type]
    (->daycounter-1 (keyword type)))
  ([type convention]
    (->daycounter-2 (keyword type) (keyword convention)))
  ([type convention schedule]
    (->daycounter-3 (keyword type) (keyword convention) schedule)))