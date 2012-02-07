(ns cantaloupe.thrift
   (:import [org.apache.thrift TBase TException TSerializer TDeserializer]
            [org.apache.thrift.protocol TProtocol TProtocolFactory TBinaryProtocol TCompactProtocol]
            [org.apache.thrift.transport TMemoryInputTransport TTransport]
            [net.cantaloupe.thrift Order Status]))

(defn to-thrift [obj]
    (let [serializer (TSerializer. (org.apache.thrift.protocol.TBinaryProtocol$Factory.))]
          (.serialize serializer obj)))

(defn to-thrift-c [obj]
      (let [serializer (TSerializer. (org.apache.thrift.protocol.TCompactProtocol$Factory.))]
                  (.serialize serializer obj)))

(defn from-thrift [thrift-payload target-obj]
    (let [deserializer (TDeserializer. (org.apache.thrift.protocol.TBinaryProtocol$Factory.))]
          (.deserialize deserializer target-obj thrift-payload))
    target-obj)

(defn from-thrift-c [thrift-payload target-obj]
      (let [deserializer (TDeserializer. (org.apache.thrift.protocol.TCompactProtocol$Factory.))]
                  (.deserialize deserializer target-obj thrift-payload))
            target-obj)

