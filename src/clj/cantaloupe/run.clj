(ns cantaloupe.run
  (:use cantaloupe.orders))

(dump-compact-thrift)
(load-compact-thrift)
(dump-thrift)
(load-thrift)
(dump-lzo-thrift)
(load-lzo-thrift)

