package com.au.tupolevbase.component.snmpadaptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("adaptor")
public class SnmpAdaptorComponentConfiguration {


    @Value("${adaptor.snmpUri}")
    private String snmpUri;

    @Value("${adaptor.kafka.broker}")
    private String broker;

    @Value("${adaptor.kafka.kafkaPrimaryUri}")
    private String kafkaPrimaryUri;

    @Value("${adaptor.kafka.kafkaDeadLetterTopicUri}")
    private String kafkaDeadLetterTopicUri;


    public SnmpAdaptorComponentConfiguration() {
    }

    public String getSnmpUri() {
        return snmpUri;
    }

    public String getKafkaPrimaryUri() {
        return kafkaPrimaryUri;
    }

    public String getKafkaDeadLetterTopicUri() {
        return kafkaDeadLetterTopicUri;
    }

    public String getBroker() {
        return broker;
    }
}
