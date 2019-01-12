package com.wmg.springbootkafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class MessageSender {

    public static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);

    @Value("${app.topic.sample}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String payload) {
        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, payload);
        if (send.isDone()) {
            LOGGER.info("Payload sent -> '{}'", payload);
        }
    }
}
