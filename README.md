# Kafka CQRS Demo
A CQRS implementation using Apache Kafka.

## Dependency
You'll need Kafka, Zookeeper, and Schema registry running in your env.
I suggest [running Confluent using Docker containers](https://docs.confluent.io/platform/current/quickstart/ce-docker-quickstart.html?utm_medium=sem&utm_source=google&utm_campaign=ch.sem_br.brand_tp.prs_tgt.confluent-brand_mt.mbm_rgn.emea_lng.eng_dv.all&utm_term=%2Bconfluent%20%2Bdocker&creative=&device=c&placement=&gclid=CjwKCAiA9bmABhBbEiwASb35V-vCeQQiwg49vsJ8DyWy6dfKxXB8lOJwrqzVcve_Zs9uuMnaTQwEwRoCsvkQAvD_BwE).

You'll also need [Postman](https://www.postman.com/downloads/) to test the demo.
## Build
Make sure that you are using Java 11+. 

Do a `./mvnw clean install` to get the following jar files:

- Command: `/command/target/command-0.0.1.jar`
- Query: `/query/target/query-0.0.1.jar`

## Run
Simultaneously run the jar files from the previous step.
- `java -jar /command/target/command-0.0.1.jar`
- `java -jar /query/target/query-0.0.1.jar`

Import `CARS.postman_collection.json` collection located in the root folder to Postman and fire some command and query requests.
