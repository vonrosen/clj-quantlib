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
  {:actual360 '(new Actual360)
   :actual365fixed '(new Actual365Fixed)
   :actual365noleap '(new Actual365NoLeap)
   :actualactual '(new ActualActual)
   :business252 '(new Business252)
   :onedaycounter '(new OneDayCounter)
   :simpledaycounter '(new SimpleDayCounter)
   :thirty360 '(new Thirty360)})

(def ^{:doc "Map of keywords into native java DayCounter Conventions."}
     keyword-to-conventions
  {:isma '(ActualActual/ISMA)
   :bond '(ActualActual/Bond)
   :isda '(ActualActual/ISDA)
   :historical '(ActualActual/Historical)
   :actual365 '(ActualActual/Actual365)
   :afb '(ActualActual/AFB)
   :euro '(ActualActual/Euro)
   :usa '(Thirty360/USA)
   :bondbasis '(Thirty360/BondBasis)
   :european '(Thirty360/European)
   :eurobondbasis '(Thirty360/EurobondBasis)
   :italian '(Thirty360/Italian)})

(defn new-java-daycounter
  ([type]
    (eval (type keyword-to-daycounters)))
  ([type convention]
    (eval 
      (apply list (conj 
                    (vec (type keyword-to-daycounters)) 
                    (convention keyword-to-conventions)))))
  ([type convention schedule]
    (eval 
      (apply list (conj 
                    (vec (type keyword-to-daycounters)) 
                    (convention keyword-to-conventions)
                    '(to-java schedule))))))

(defprotocol DayCounter
 (to-java [this]))

(defrecord daycounter-1 [type]
  DayCounter
  (to-java [this]
    (new-java-daycounter type)))
(defrecord daycounter-2 [type convention]
  DayCounter
  (to-java [this]
    (new-java-daycounter type convention)))
(defrecord daycounter-3 [type convention schedule]
  DayCounter
  (to-java [this]
    (new-java-daycounter type convention schedule)))
(defn day-counter 
  ([type]
    (->daycounter-1 (keyword type)))
  ([type convention]
    (->daycounter-2 (keyword type) (keyword convention)))
  ([type convention schedule]
    (->daycounter-3 (keyword type) (keyword convention) schedule)))