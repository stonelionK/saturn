package com.kt.conv.robotvtf.qat.mqm;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kt.conv.robotvtf.qat.dto.GeneralMessage;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class RmqCmddMessageSender {


	private final RabbitTemplate rabbitTemplate;
	@Value("${mq.qat.exchange.name}")
	private String exchangename;
	
	
	@Value("${rmq.qat.que.name}")
	private String qname;
	
			

    public RmqCmddMessageSender(RabbitTemplate rmqtemplate) {
    	this.rabbitTemplate=rmqtemplate;
    }
    
    
    
	 public void sendCommand(String routingkey, Message sendmessage) {
		 rabbitTemplate.send(exchangename, routingkey, sendmessage); //exchane, routing, message
	 }
	 
	 
	 /*
	        rabbit.convertAndSend("tacocloud.order.queue", order,
	                new MessagePostProcessor() {
	                    @Override
	                    public Message postProcessMessage(Message message)
	                            throws AmqpException {
	                        MessageProperties props = message.getMessageProperties();
	                        props.setHeader("X_ORDER_SOURCE", "WEB");
	                        return message;
	                    }
	                });
	    }
	 */
    

    
}