package io.swagger.consumer_kafka;

import io.swagger.kafka_model.ContractKafka;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(ContractKafka.class);

    @KafkaListener(topics = "contract", groupId = "group_id")
    public void consume(ContractKafka contract) {
        // update contract data for invoicing
        logger.info(String.format("#### -> Consuming contract -> %s", contract));

    }
}
