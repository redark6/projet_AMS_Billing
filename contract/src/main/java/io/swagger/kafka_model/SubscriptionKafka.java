package io.swagger.kafka_model;

import io.swagger.model.BusinessAddress;

public class SubscriptionKafka {
    public String contractRef;
    public String subscriberRef;
    public String subscriberType;
    public String contactPerson;
    public BusinessAddress contactAddress;
    public BusinessAddress billingAddress;

    public SubscriptionKafka() {}

    public SubscriptionKafka(String contractRef ,String subscriberRef, String subscriberType, String contactPerson, BusinessAddress contactAddress, BusinessAddress billingAddress) {
        this.contractRef = contractRef;
        this.subscriberRef = subscriberRef;
        this.subscriberType = subscriberType;
        this.contactPerson = contactPerson;
        this.contactAddress = contactAddress;
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "SubscriptionKafka{" +
                "contractRef='" + contractRef + '\'' +
                ", subscriberRef='" + subscriberRef + '\'' +
                ", subscriberType='" + subscriberType + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", contactAddress=" + contactAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
