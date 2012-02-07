(ns cantaloupe.orders
  (:use cascalog.api)
  (:require [cascalog [workflow :as w] [ops :as c] [vars :as v]])
  (:use [cantaloupe.thrift])
  (:import [net.cantaloupe.thrift Order Status])
  (:import [backtype.hadoop ThriftSerialization]))


(defn- deserialize-order [d] (from-thrift-c d (Order.)))
(defn- getAmount [^Order t] (.getAmount t))

;; Generate 10 serialized random orders

(def orders
    (vec (for [i (range 100 110)]
     (let [r (rand-int 2)]
      (vector (to-thrift-c
       (doto (Order.)
            (.setOid i)
            (.setAmount (+ 9.9 i))
            (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED)))))))))

(println orders)

;; Dump orders

(?<- (hfs-seqfile "/tmp/thrift-orders" :sinkmode :replace)
      [?o]
      (orders ?o))

;; Reload orders and display amount

(?<- (stdout)
      [?a]
      ((hfs-seqfile "/tmp/thrift-orders") ?s)
      (deserialize-order ?s :> ?d)
      (getAmount ?d :> ?a))
;;      (* 2 ?b :> ?c))

