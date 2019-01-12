package com.wmg.springbootkafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${app.topic.sample}")
    public void messageReceiver(@Payload String payload) {
        LOGGER.info("Received message -> '{}'", payload);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
