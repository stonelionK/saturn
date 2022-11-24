package com.kt.conv.robotvtf.qat.entity;

import lombok.Data;

@Data
public class Auth {
	
	
	String authType="";
	String accessToken="";
	User user=null;

}
