package com.kt.conv.robotvtf.qat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = "classpath:config/application-${runtime.mode}.properties", ignoreResourceNotFound = false)
public class SimpleIntegrationTestHelperApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SimpleIntegrationTestHelperApplication.class, args);
	}

	
}
