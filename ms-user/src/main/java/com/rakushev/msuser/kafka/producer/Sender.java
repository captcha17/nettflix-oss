package com.rakushev.msuser.kafka.producer;

import com.rakushev.msuser.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class Sender {
    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    private KafkaTemplate<String, User> kafkaTemplate;

    @Autowired
    public Sender(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic, User payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
        kafkaTemplate.send(topic, payload);
    }
}
