(ns clj-quantlib.time.schedule)

(defrecord schedule-1 [dates business-day-convention])
(defrecord schedule-2 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date next-to-last-date])
(defrecord schedule-3 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month first-date])
(defrecord schedule-4 [effective-date termination-date tenor business-day-convention 
                       termination-date-convention date-generation-rule end-of-month])

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