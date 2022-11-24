package com.kt.conv.robotvtf.qat.mqm.example;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.kt.conv.robotvtf.qat.mqm.FactoryUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLogTopic {

	
	
    private static final String EXCHANGE_NAME = "topic_logs";

    
   
    
    public static void main(String[] argv) throws Exception {
   
    	for(int i=0; i<100; i++) {
    		t1(i);
    		Thread.sleep(10);
    	}
    }
    
    public static void t1(int count) throws IOException, TimeoutException {
    	
    	ConnectionFactory factory = new FactoryUtil().getDefaultFactory("");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            channel.exchangeDeclare(EXCHANGE_NAME, "topic");

            String[] argv = new String[1];
            if((count % 2)==0) {
            	argv[0]= "com.anonymous.info";
            }else {
            	argv[0]= "kern.critical";
            }


            

            String routingKey = getRouting(argv);
            String message = String.valueOf(count) + getMessage(argv);

            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
    }

    private static String getRouting(String[] strings) {
        if (strings.length < 1)
            return "anonymous.info";
        return strings[0];
    }

    private static String getMessage(String[] strings) {
        if (strings.length < 2)
            return " Hello World!";
        return joinStrings(strings, " ", 1);
    }

    private static String joinStrings(String[] strings, String delimiter, int startIndex) {
        int length = strings.length;
        if (length == 0) return "";
        if (length < startIndex) return "";
        StringBuilder words = new StringBuilder(strings[startIndex]);
        for (int i = startIndex + 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}