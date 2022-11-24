package com.kt.conv.robotvtf.qat.dto;

import com.kt.conv.robotvtf.qat.dto.PKMConstants.DEPARTMENT;
import com.kt.conv.robotvtf.qat.dto.PKMConstants.PACKAGE_TYPE;

import lombok.Data;

@Data
public class PackageInfoVo {
	
	
	PACKAGE_TYPE type;
	DEPARTMENT department;
	String name="";
	String version="";
	String downloadurl="";
	String owner="";
	long size;

}