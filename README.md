# Kafka CQRS Demo
A CQRS implementation using Apache Kafka.

## Build
Just do a `mvn clean install` to get the following jar files:

- Command: `/command/target/command-0.0.1.jar`
- Query: `/query/target/query-0.0.1.jar`

And then run the jar files simultaneously in two different terminals.

Oh, also you need Kafka, Zookeeper, and Schema registry running in your env. I suggest [running Confluent using Docker containers](https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html?utm_medium=sem&utm_source=google&utm_campaign=ch.sem_br.brand_tp.prs_tgt.confluent-brand_mt.mbm_rgn.emea_lng.eng_dv.all&utm_term=%2Bconfluent%20%2Bdocker&creative=&device=c&placement=&gclid=CjwKCAiA9bmABhBbEiwASb35V-vCeQQiwg49vsJ8DyWy6dfKxXB8lOJwrqzVcve_Zs9uuMnaTQwEwRoCsvkQAvD_BwE).