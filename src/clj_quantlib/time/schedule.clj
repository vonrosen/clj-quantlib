(ns clj-quantlib.time.schedule
  (:require 
    [clj-quantlib.time.businessdayconvention :refer [keywords-to-businessdayconvention]]
    [clj-quantlib.time.dategenerationrule :refer [keywords-to-dategenerationrule]])
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
    (new Schedule 
         (to-java effective-date) 
         (to-java termination-date) 
         (to-java tenor)
         (business-day-convention keywords-to-businessdayconvention)
         (termination-date-convention keywords-to-businessdayconvention)
         (date-generation-rule keywords-to-dategenerationrule)
         end-of-month)))

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