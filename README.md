# springboot-kafka

SpringBoot + Kafka configuration setup for simple consumer/producer application

## Setup kafka on local machine

Follow https://kafka.apache.org/quickstart 

or

Download kafka and use [this](https://gist.github.com/wmg2328/4e44623f531ef4067f45106058a620a9) scripts.


## 🔨 Building from source

Prerequisites:

- Java 8
- Gradle 4.4>

Steps:

1. Clone springboot-kafka (or download the source code and extract it) and navigate
  into it:

   ```sh
   git clone https://github.com/wmg2328/springboot-kafka.git
   cd springboot-kafka
   ```

2. Run following command on terminal to build and deploy application:

   ```./gradlew build && java -jar build/libs/springboot-kafka-1.0.0.jar```
