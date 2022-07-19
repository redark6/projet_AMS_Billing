package io.swagger.kafka_model;

import org.threeten.bp.LocalDate;

public class ContractKafka {
    public String productRef;
    public String contractType;
    public String activatedAt;
    public String expireAt;
    public String status;

    public ContractKafka() {}

    public ContractKafka(String productRef, String contractType, String activatedAt, String expireAt, String status) {
        this.productRef = productRef;
        this.contractType = contractType;
        this.activatedAt = activatedAt;
        this.expireAt = expireAt;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ContractKafka{" +
                "productRef='" + productRef + '\'' +
                ", contractType='" + contractType + '\'' +
                ", activatedAt='" + activatedAt + '\'' +
                ", expireAt='" + expireAt + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
