(ns cantaloupe.orders
  (:use cascalog.api)
  (:require [cascalog [workflow :as w] [ops :as c] [vars :as v]])
  (:use [cantaloupe.thrift])
  (:use cascalog.lzo)
  (:import [net.cantaloupe.thrift Order Status]))

(defn- deserialize-order [d] (from-compact-thrift d (Order.)))
(defn- getAmount [^Order t] (.getAmount t))

;; Generate 100 serialized random orders

(def orders
    (vec (for [i (range 100 200)]
     (let [r (rand-int 2)]
      (vector (to-compact-thrift
       (doto (Order.)
            (.setOid i)
            (.setAmount (+ 9.9 i))
            (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED)))))))))

(def orders2
      (vec (for [i (range 100 200)]
        (let [r (rand-int 2)]
          (vector
            (doto (Order.)
              (.setOid i)
              (.setAmount (+ 9.9 i))
              (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED))))))))


;; Dump orders
(defn dump-orders []
  (?<- (hfs-seqfile "/tmp/thrift-orders" :sinkmode :replace)
        [?o]
        (orders ?o)))

(defn dump-lzo []
  (?- (hfs-lzo-thrift "/tmp/lzo-orders" Order :sinkmode :replace)
      orders2))

(defn dump-orders2 []
  (?<- (hfs-seqfile "/tmp/thrift-orders2" :sinkmode :replace)
        [?o]
       (orders2 ?o)))

;; Reload orders and display amount
(def orders-src (hfs-seqfile "/tmp/thrift-orders"))

(def orders-src2 (hfs-seqfile "/tmp/thrift-orders2"))

(defn load-orders []
  (?<- (stdout)
        [?a]
        (orders-src ?s)
        (deserialize-order ?s :> ?d)
        (getAmount ?d :> ?a)))

(defn load-orders2 []
  (?<- (stdout)
       [?a]
       (orders-src2 ?s)
       (getAmount ?s :> ?a)))


