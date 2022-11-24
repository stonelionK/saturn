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
@Entity @Table(name = "tbl_robot", indexes = @Index(columnList = "id"))

public class Robot {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id = ""; //mac address
	
	private String name = "";
	private String alias = "";
	private String model = "";
	private String type = "";
	private String serial = "";
	private String isUse = "";
	private String birthdate = "";
	private String workstarte = "";
	private String ip    = "";

}
