(ns cantaloupe.orders
  (:use cascalog.api)
  (:require [cascalog [workflow :as w] [ops :as c] [vars :as v]])
  (:use [cantaloupe.thrift])
  (:import [net.cantaloupe.thrift Order Status])
  (:import [backtype.hadoop ThriftSerialization]))


(defn make-order [d] (from-thrift-c d (Order.)))
(defn getAmount [^Order t] (.getAmount t))

(def orders
    (vec (for [i (range 100 110)]
     (let [r (rand-int 2)]
      (vector (to-thrift-c
       (doto (Order.)
            (.setOid i)
            (.setAmount (+ 9.9 i))
            (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED)))))))))

(println orders)

(?<- (hfs-seqfile "/tmp/thrift-orders" :sinkmode :replace)
      [?o]
      (orders ?o))

(println "reloading")

(?<- (stdout)
      [?b ?c]
      ((hfs-seqfile "/tmp/thrift-orders") ?o)
      (make-order ?o :> ?a)
      (getAmount ?a :> ?b)
      (* 2 ?b :> ?c))

