(ns clj-quantlib.time.businessdayconvention
  (:import (com.github.vonrosen.quantlib BusinessDayConvention)))

(def ^{:doc "Map of keywords into native java BusinessDayConvention objects."}
     keywords-to-businessdayconvention
  {:following (BusinessDayConvention/Following)
   :modifiedfollowing (BusinessDayConvention/ModifiedFollowing)
   :preceding (BusinessDayConvention/Preceding)
   :modifiedpreceding (BusinessDayConvention/ModifiedPreceding)
   :unadjusted (BusinessDayConvention/Unadjusted)
   :halfmonthmodifiedfollowing (BusinessDayConvention/HalfMonthModifiedFollowing)})