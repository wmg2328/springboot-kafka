package com.wmg.springbootkafka;

import com.wmg.springbootkafka.consumer.MessageConsumer;
import com.wmg.springbootkafka.producer.MessageSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = {SpringbootKafkaApplicationTests.testTopic}, partitions = 1)
public class SpringbootKafkaApplicationTests {

    @Autowired
    private MessageConsumer messageConsumer;

    @Autowired
    private MessageSender messageSender;

    static final String testTopic = "sample.test.topic";

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMain() {
        SpringbootKafkaApplication.main(new String[]{});
    }

    @Test
    public void testReceive() throws Exception {
        messageSender.sendMessage("Hello Test Message");

        messageConsumer.getLatch().await(1000, TimeUnit.MILLISECONDS);
        assertThat(messageConsumer.getLatch().getCount()).isEqualTo(0);
    }

}

