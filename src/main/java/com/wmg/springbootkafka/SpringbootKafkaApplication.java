package com.wmg.springbootkafka;

import com.wmg.springbootkafka.producer.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootKafkaApplication implements CommandLineRunner {

    @Autowired
    private MessageSender messageSender;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        messageSender.sendMessage("This is a sample message 1");
    }
}

