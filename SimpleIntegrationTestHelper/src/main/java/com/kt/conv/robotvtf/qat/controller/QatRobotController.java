package com.kt.conv.robotvtf.qat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kt.conv.robotvtf.qat.dto.MQCommandRequesMessage;
import com.kt.conv.robotvtf.qat.service.DeployService;

@Controller
public class QatRobotController {

	
	DeployService deployservice;
	
	
	@PostMapping("/initialize") /* backup config, source, bin..exec bash_shell(backup) */
    public String initializeRobot(@RequestBody MQCommandRequesMessage requestmessage){
        return "simple_info";
    }
	
	@PostMapping("/deploy") /* backup config, source, bin..exec bash_shell(backup) */
    public String deploypackage(@RequestBody MQCommandRequesMessage requestmessage){
        return deployservice.deploy(requestmessage);
    }
	
	
    /*
     * 1. objet --> json
     *   String jsonStr = gson.toJson(jsonObject);
     * 2. Json -> object
     *    Student student = gson.fromJson(jsonStr, Student.class);
     */
	
	
	
}
