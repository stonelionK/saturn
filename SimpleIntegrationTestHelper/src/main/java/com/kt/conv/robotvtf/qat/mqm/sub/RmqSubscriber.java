package com.kt.conv.robotvtf.qat.mqm.sub;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RmqSubscriber {


	@Autowired
	Environment env; 

	@RabbitListener()    
	public void receiveMessage(final Message message) {
		log.info(message.toString());
		log.info(env.getProperty(""));
	}


	
	/*https://kr.coderbridge.com/questions/e767e12db7c04c57bae77510578157e3
	 * rmq.qat.cluster.host=api.acp.kt.co.kr
rmq.qat.mqtt.port=9910
rmq.qat.amqp.port=9911
rmq.qat.exchange.name=xc.cmd.qat.topic
rmq.qat.que.name=que.cmd.qat
rmq.qat.user=qat
rmq.qat.pwd=qat12#$
rmq.qat.vhost=qavhost
rmq.qat.nework.recovery.interval=300000 //ms

	 */
	/*
	    private static final String QAT_EXCHANGE_NAME = "topic_logs";

	    public static void main(String[] argv) throws Exception {

	        ConnectionFactory factory = new FactoryUtil().getDefaultFactory("");

	        Connection connection = factory.newConnection();
	        Channel channel = connection.createChannel();

	        channel.exchangeDeclare(QAT_EXCHANGE_NAME, "topic");
	        String queueName = channel.queueDeclare().getQueue();


	        for (String bindingKey : argv) {
	            channel.queueBind(queueName, QAT_EXCHANGE_NAME, bindingKey);
	        }

	        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
	            String message = new String(delivery.getBody(), "UTF-8");
	            System.out.println(" [x] Received '" + delivery.getEnvelope().getRoutingKey() + "':'" + message + "'");
	        };
	        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> { });
	    }
	 */
}