package io.swagger.producer_kafka;

import io.swagger.kafka_model.ContractKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerContract {

    private static final String TOPIC = "contract";

    @Autowired
    private KafkaTemplate<String, ContractKafka> kafkaTemplate;

    public void sendMessage(ContractKafka contract) {
        this.kafkaTemplate.send(TOPIC, contract);
    }
}
