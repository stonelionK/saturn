package com.kt.conv.robotvtf.qat.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;


@Getter
public class GitProject extends Project{
	
	String path="";
	String branchName="";
	String path_with_namespace=""; //"ai-robot-platform-dev/robotqatdeploymanager",
	String latestTagName=""; 
	List<String> taglist;
	
	
	
	public void setPath(String path) {
		this.path = path;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public void setPath_with_namespace(String path_with_namespace) {
		this.path_with_namespace = path_with_namespace;
	}
	
	
	public void setTaglist(ArrayList<String> taglist) {
		this.taglist = taglist;
		this.latestTagName = getLatestTagName(taglist);
	}
	
	private static String getLatestTagName(ArrayList<String> taglist) {

		if(taglist==null || taglist.size()<1)
		return null;
		
		List<String> ntaglist= new ArrayList<String>();
		for(int i=0; i<taglist.size(); i++) {
			ntaglist.add(taglist.get(i).replaceAll(".", ""));
		}
		
		Collections.sort(ntaglist);
		
		return ntaglist.get(ntaglist.size()-1);
	}
	
	
	

}
