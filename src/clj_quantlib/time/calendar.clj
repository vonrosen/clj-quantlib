(ns clj-quantlib.time.calendar  
  (:import (com.github.vonrosen.quantlib Month)
           (com.github.vonrosen.quantlib Date)           
           (com.github.vonrosen.quantlib TARGET)))

(def ^{:doc "Map of month keywords into native java Month objects."}
     keywords-to-months
  {:january (Month.January)
   :february (Month.February)
   :march (Month.March)
   :april (Month.April)
   :may (Month.May)
   :june (Month.June)
   :july (Month.July)
   :august (Month.August)
   :september (Month.September)
   :october (Month.October)
   :november (Month.November)
   :december (Month.December)})

(def ^{:doc "Map of native java Month objects into java keywords."}
     months-to-keywords
  (clojure.set/map-invert keywords-to-months))

(defprotocol IDate
  (from-java [date-java])
  (to-java [this])  
  (date-adjusted [this])
  (date-add [period]))

(defrecord date-1 [date month year]
  IDate  
  (to-java [this]
    (new Date date (month keywords-to-months) year))
  (from-java [date-java]
    (let [d (.dayOfMonth date-java)
          m (.month date-java)
          y (.year date-java)]
      (->date-1 d (m months-to-keywords) y)))
  (date-adjusted [this]
    (let [date-adjusted-java (doto 
                               (new TARGET)
                               (.adjust (to-java this)))]
    (from-java date-adjusted-java)))
  (date-add [period]
    (let [date-java-added-to (.add (to-java this) (to-java period))]
       (from-java date-java-added-to))))

(defrecord date-2 [serialnumber]
  IDate
  (from-java [date-java] #_todo)
  (to-java [this] #_todo)  
  (date-adjusted [this] #_todo)
  (date-add [period] #_todo))

(defrecord date-3 [datestr fmt]
  IDate
  (from-java [date-java] #_todo)
  (to-java [this] #_todo)  
  (date-adjusted [this] #_todo)
  (date-add [period] #_todo))