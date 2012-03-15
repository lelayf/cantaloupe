(defproject cantaloupe "1.0.0-SNAPSHOT"
  :description "FIXME: write description"
  :source-path "src/clj"
  :java-source-path "src/jvm"
  :resources-path "resources"
  :jvm-opts ["-Xmx768m" "-server"]
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [cascalog "1.9.0-wip7"]
                 [cascalog-lzo "0.1.0-wip7"]
                 [backtype/cascading-thrift "0.2.0"]
                 [org.apache.thrift/libthrift "0.8.0"]]
  :dev-dependencies [[org.apache.hadoop/hadoop-core "0.20.2-dev"]])
