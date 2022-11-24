package com.kt.conv.robotvtf.qat.mqm;

public interface MqmMessageSender {
	
	abstract void buildFactory();
	abstract void generateRoutingKey();
	abstract void publishMessage();
	

}
