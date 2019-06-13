package com.au.tupolevbase.component.snmpadaptor;

import com.au.tupolevbase.component.snmpadaptor.routes.CamelSnmpTrapRoute;
import org.apache.camel.CamelContext;
import org.apache.camel.component.kafka.KafkaComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SnmpadaptorApplication {

	@Autowired
	CamelSnmpTrapRoute camelSnmpTrapRoute;

	@Autowired
	SnmpAdaptorComponentConfiguration snmpAdaptorComponentConfiguration;

	@Bean
	public CamelContext createCamelRoute() throws Exception {
		CamelContext context = new DefaultCamelContext();
		KafkaComponent kafkaComponent = new KafkaComponent();
		kafkaComponent.setBrokers("localhost:9092");
		context.addComponent("kafka",kafkaComponent);
		context.addRoutes(camelSnmpTrapRoute);
		context.start();
		return context;
	}

	public static void main(String[] args) {
		SpringApplication.run(SnmpadaptorApplication.class, args);
	}

}
