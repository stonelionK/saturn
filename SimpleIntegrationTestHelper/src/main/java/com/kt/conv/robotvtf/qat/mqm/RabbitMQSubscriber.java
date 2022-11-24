package com.kt.conv.robotvtf.qat.mqm;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RabbitMQSubscriber {
	
	private RabbitTemplate rqmtemplate;
	
	public RabbitMQSubscriber(RabbitTemplate rqmtemplate) {
		this.rqmtemplate=rqmtemplate;
	}
	  
	
	public Object subcribeCmd() {
		log.info("subscribCmd");
		return rqmtemplate.receiveAndConvert();
	}

}
