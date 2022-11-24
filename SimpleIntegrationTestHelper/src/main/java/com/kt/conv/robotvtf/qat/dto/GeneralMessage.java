package com.kt.conv.robotvtf.qat.dto;

import java.io.Serializable;

public class GeneralMessage implements Serializable{
	
	private static final long serialVersionUID = 4201608626192958349L;
	
	String msgid=""; //
	int msgseq; //for each msgid
	String reqdate; //timestamp
	String resdate;//timestamp
	String msgformat = "";
	byte[] msg;

}
