(ns cantaloupe.orders
  (:use cascalog.api)
  (:require [cascalog [workflow :as w] [ops :as c] [vars :as v]])
  (:use [cantaloupe.thrift])
  (:import [net.cantaloupe.thrift Order Status]))
;  (:import [backtype.hadoop ThriftSerialization]))

(defn- deserialize-order [d] (from-compact-thrift d (Order.)))
(defn- getAmount [^Order t] (.getAmount t))

;; Generate 10 serialized random orders

(def orders
    (vec (for [i (range 100 200)]
     (let [r (rand-int 2)]
      (vector (to-compact-thrift
       (doto (Order.)
            (.setOid i)
            (.setAmount (+ 9.9 i))
            (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED)))))))))

;;(println orders)

;; Dump orders
(defn dump-orders []
  (?<- (hfs-seqfile "/tmp/thrift-orders" :sinkmode :replace)
        [?o]
        (orders ?o)))

;; Reload orders and display amount

(def orders-src (hfs-seqfile "/tmp/thrift-orders"))

(defn load-orders []
  (?<- (stdout)
        [?a]
        (orders-src ?s)
        (deserialize-order ?s :> ?d)
        (getAmount ?d :> ?a)))

;;      (* 2 ?b :> ?c))

