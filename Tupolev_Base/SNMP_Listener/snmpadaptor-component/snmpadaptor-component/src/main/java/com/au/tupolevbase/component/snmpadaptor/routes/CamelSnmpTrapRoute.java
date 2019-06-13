package com.au.tupolevbase.component.snmpadaptor.routes;

import com.au.tupolevbase.component.snmpadaptor.SnmpAdaptorComponentConfiguration;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelSnmpTrapRoute extends RouteBuilder{

    @Autowired
    SnmpAdaptorComponentConfiguration snmpAdaptorComponentConfiguration;


    @Override
    public void configure() throws Exception {

        from(snmpAdaptorComponentConfiguration.getSnmpUri())
                .convertBodyTo(String.class)
                .to(snmpAdaptorComponentConfiguration.getKafkaPrimaryUri())
                .onException(Exception.class)
                .useOriginalMessage()
                .handled(true)
                .to(snmpAdaptorComponentConfiguration.getKafkaDeadLetterTopicUri());
    }
}
