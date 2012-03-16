(ns cantaloupe.orders
  (:use cascalog.api)
  (:require [cascalog [workflow :as w] [ops :as c] [vars :as v]])
  (:use [cantaloupe.thrift])
  (:use cascalog.lzo)
  (:import [net.cantaloupe.thrift Order Status]))

(defn- deserialize-order [d] (from-compact-thrift d (Order.)))
(defn- getAmount [^Order t] (.getAmount t))

;; Generate 100 serialized random orders

(def compact-thrift-orders
    (vec (for [i (range 100 200)]
     (let [r (rand-int 2)]
      (vector (to-compact-thrift
       (doto (Order.)
            (.setOid i)
            (.setAmount (+ 9.9 i))
            (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED)))))))))

(def thrift-orders
      (vec (for [i (range 100 200)]
        (let [r (rand-int 2)]
          (vector
            (doto (Order.)
              (.setOid i)
              (.setAmount (+ 9.9 i))
              (.setStatus (cond (= r 0) Status/PENDING (= r 1) Status/DESPATCHED))))))))


;; Dump orders
(defn dump-compact-thrift []
  (?<- (hfs-seqfile "/tmp/compact-thrift-orders" :sinkmode :replace)
        [?o]
        (compact-thrift-orders ?o)))

(defn dump-thrift []
  (?<- (hfs-seqfile "/tmp/thrift-orders" :sinkmode :replace)
       [?o]
       (thrift-orders ?o)))

(defn dump-lzo-thrift []
  (?- (hfs-lzo-thrift "/tmp/lzo-thrift-orders" Order :sinkmode :replace)
      thrift-orders))

;; Reload orders and display amount
(def src-compact-thrift (hfs-seqfile "/tmp/compact-thrift-orders"))

(def src-thrift (hfs-seqfile "/tmp/thrift-orders"))

(def src-lzo-thrift (hfs-lzo-thrift "/tmp/lzo-thrift-orders" Order))

;; loaders 
(defn load-compact-thrift []
  (?<- (stdout)
        [?a]
        (src-compact-thrift ?s)
        (deserialize-order ?s :> ?d)
        (getAmount ?d :> ?a)))

(defn load-thrift []
  (?<- (stdout)
       [?a]
       (src-thrift ?s)
       (getAmount ?s :> ?a)))

(defn load-lzo-thrift []
  (?<- (stdout)
       [?a]
       (src-lzo-thrift ?s)
       (getAmount ?s :> ?a)))


