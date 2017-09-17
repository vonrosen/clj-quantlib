(ns clj-quantlib.time.schedule
  (:import (com.github.vonrosen.quantlib Schedule)))

(defprotocol ISchedule
  (to-java [this]))

(defrecord schedule-1 [dates business-day-convention]
  ISchedule
  (to-java [this]
    #_todo))

(defrecord schedule-2 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date next-to-last-date]
  ISchedule
  (to-java [this]
    #_todo))

(defrecord schedule-3 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date]
  ISchedule
  (to-java [this]
    #_todo))

(defrecord schedule-4 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month]
  ISchedule
  (to-java [this]
    todo))

(defn schedule
  ([dates business-day-convention]
    (->schedule-1 dates business-day-convention))
  ([effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date next-to-last-date]
    (->schedule-2 effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date next-to-last-date))
  ([effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date]
    (->schedule-3 effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date))
  ([effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month]
    (->schedule-4 effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month)))