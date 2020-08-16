package com.camel.example4;

import javax.jms.ConnectionFactory;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

public class FiletoActiveMQ {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();
		
//		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//		context.addComponent("jms", JmsComponent.jmsComponent(connectionFactory));
		context.addRoutes(new RouteBuilder() {
			
			@Override
			public void configure() throws Exception {
				
				from("file:input_box?noop=true")
				.to("activemq:queue:mqqueue");
			}
		});

		while(true)
			context.start();
	}

}
