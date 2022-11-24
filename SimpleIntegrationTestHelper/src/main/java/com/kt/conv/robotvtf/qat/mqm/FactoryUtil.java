package com.kt.conv.robotvtf.qat.mqm;

import org.springframework.beans.factory.annotation.Value;

import com.rabbitmq.client.ConnectionFactory;

public class FactoryUtil {
	
	
	@Value("${rmq.qat.cluster.host}")
	String host;
	
	
	@Value("${rmq.qat.amqp.port}")
	int rmqPort;
			

	@Value("${rmq.qat.user}")
	String username;
	
	@Value("${rmq.qat.pwd}")
	String userpasswd;
	
	@Value("${rmq.qat.nework.recovery.interval}")
	int networkRecoveryInterval;
	
	@Value("${rmq.qat.vhost}")
	String vhost;
	
	
	
	public ConnectionFactory getDefaultFactory(String mode) {
	
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(host);
	    factory.setUsername(username);
	    factory.setPassword(userpasswd);
	    factory.setVirtualHost(vhost);
	    factory.setNetworkRecoveryInterval(networkRecoveryInterval);
	    factory.setPort(rmqPort);
	    
	    
	    return factory;
	    
	}

}
