package io.swagger.producer_kafka;

import io.swagger.kafka_model.SubscriptionKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerSubscription {

    private static final String TOPIC = "subscription";

    @Autowired
    private KafkaTemplate<String, SubscriptionKafka> kafkaTemplate;

    public void sendMessage(SubscriptionKafka subscription) {
        this.kafkaTemplate.send(TOPIC, subscription);
    }
}
