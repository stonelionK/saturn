package com.kt.conv.robotvtf.qat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class GreetingController {



	@Value("${git.url}")
	private String giturl;

	@Value("${rmq.qat.cluster.host}")
	private String mqhost;


	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("name",mqhost);
		
		return "hello";
	}


}
