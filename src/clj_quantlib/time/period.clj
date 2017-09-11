(ns clj-quantlib.time.period
  (:import (com.github.vonrosen.quantlib TimeUnit)
           (com.github.vonrosen.quantlib Frequency)
           (com.github.vonrosen.quantlib Period)))

(def ^{:doc "Map of time unit keywords into native java TimeUnit objects."}
     keywords-to-time-units
  {:days (TimeUnit/Days)
   :weeks (TimeUnit/Weeks)
   :months (TimeUnit/Months)
   :years (TimeUnit/Years)
   :hours (TimeUnit/Hours)
   :minutes (TimeUnit/Minutes)
   :seconds (TimeUnit/Seconds)
   :milliseconds (TimeUnit/Milliseconds)
   :microseconds (TimeUnit/Microseconds)})

(def ^{:doc "Map of frequency keywords into native java Frequency objects."}
     keywords-to-frequency
  {:nofrequency (Frequency/NoFrequency)
   :once (Frequency/Once)
   :annual (Frequency/Annual)
   :semiannual (Frequency/Semiannual)
   :everyfourthmonth (Frequency/EveryFourthMonth)
   :quarterly (Frequency/Quarterly)
   :bimonthly (Frequency/Bimonthly)
   :monthly (Frequency/Monthly)
   :everyfourthweek (Frequency/EveryFourthWeek)
   :biweekly (Frequency/Biweekly)
   :weekly (Frequency/Weekly)
   :daily (Frequency/Daily)
   :otherfrequency (Frequency/OtherFrequency)})

(defprotocol ITimeUnit
  (to-java [this]))

(defrecord period-1 [time-unit units]
  ITimeUnit
  (to-java [this]
    (new Period units (time-unit keywords-to-time-units))))

(defrecord period-2
  ITimeUnit
  [frequency]
  (to-java [this]
    (new Period (frequency keywords-to-frequency))))

(defn period 
  ([n units]
    (->period-1 (keyword n) units))
  ([frequency]
    (->period-2 (keyword frequency))))