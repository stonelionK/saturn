package com.kt.conv.robotvtf.qat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kt.conv.robotvtf.qat.dto.RequestMessage;

@Controller
public class QATEnvironmentController {
	
    @PostMapping("/initializeRobot")
    public String initializeRobot(@RequestBody RequestMessage requestmessage){
        return "simple_info";
    }
    
    /*
     * 1. objet --> json
     *   String jsonStr = gson.toJson(jsonObject);
     * 2. Json -> object
     *    Student student = gson.fromJson(jsonStr, Student.class);
     */

}
