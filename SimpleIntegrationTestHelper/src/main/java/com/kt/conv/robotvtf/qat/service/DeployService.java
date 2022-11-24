package com.kt.conv.robotvtf.qat.service;

import com.kt.conv.robotvtf.qat.dto.MQCommandRequesMessage;
import com.kt.conv.robotvtf.qat.dto.PKMConstants.DEPLOY_STATUS;


public class DeployService {
	
	public DeployService() {
		
	}
	
	/**
	 * select robot from robot list(all, selected robot)
	 * send command, 
	 */
	
	public String deploy(MQCommandRequesMessage requestmessage) {
		return DEPLOY_STATUS.CMD_SEND_OK.toString();
		
	}

}
