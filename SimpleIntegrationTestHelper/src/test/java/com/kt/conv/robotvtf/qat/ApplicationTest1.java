package com.kt.conv.robotvtf.qat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.kt.conv.robotvtf.qat.controller.GreetingController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTest1 {

	
	@Autowired
	private GreetingController greetingController;
//	private EmbeddedWebApplicationContext context;
	
	private int port;
	
	@DisplayName("spring boot endpoint test.")
	@Test
	void cxt_loading_test(){
		assert greetingController!=null;
	}
	
	
	// https://github.com/dsyer/spring-boot-mustache/blob/main/src/test/java/org/springframework/boot/mustache/web/ApplicationTests.java
		
	/*
	@Before
	public void init() {
		port = context.getEmbeddedServletContainer().getPort();
	}
	 * 
	 * 

	@Test
	public void contextLoads() {
		String source = "Hello {{arg}}!";
		Template tmpl = Mustache.compiler().compile(source);
		Map<String, String> context = new HashMap<String, String>();
		context.put("arg", "world");
		assertEquals("Hello world!", tmpl.execute(context)); // returns "Hello world!"
	}
	
	 */
	@DisplayName("print hello, test.")
	@Test
	void TC_hello_print() {
		Map<String, String> model=new HashMap<String,String>();
		model.put("name",",kim");
//		assert greetingController.hello().equals("hello,kim");
	}
	
	
}
