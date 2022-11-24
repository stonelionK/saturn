package com.kt.conv.robotvtf.qat.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity @Table(name = "tbl_package_info", indexes = @Index(columnList = "id"))
public class PackageInfo {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private String id= "";	
	
	private String type= "";  	
	private String name= "";
	private String fullName=""; //name+version
	private String owner 	="";
	private String department 	="";
	
	private String version   ="";
	private String register  ="";
	private String registDate="";
	private long size		=0L;
	private String fileFormat  =""; //zip, tgz
	private String filePath    ="";
	private String fileName    = ""; //fullname+seperator+fileformat
	private String hashcode = "";
	private String description  ="";
	
}
