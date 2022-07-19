package io.swagger.consumer_kafka;

import io.swagger.kafka_model.SubscriptionKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerSubscription {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionKafka.class);

    @KafkaListener(topics = "subscription", groupId = "group_id")
    public void consume(SubscriptionKafka subscription) {
        // modify the contract and add a subscriber
        logger.info(String.format("#### -> Producing subscription -> %s", subscription));

    }
}
