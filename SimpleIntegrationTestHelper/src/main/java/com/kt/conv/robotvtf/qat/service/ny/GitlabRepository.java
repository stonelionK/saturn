package com.kt.conv.robotvtf.qat.service.ny;

import com.kt.conv.robotvtf.qat.entity.Auth;

public class GitlabRepository implements Repository{
	

	
	@Override
	public boolean connect(Auth auth) {
		return false;
	}
	
	@Override
	public boolean download(String url) {
		return false;
	}
	
	@Override
	public boolean upload() {
		return false;
	}
	
	
	public static void printAll() {};
	
	
	public static void main(String[] args) {
		GitlabRepository gilabrepo = new GitlabRepository();
		System.out.println(gilabrepo.download(""));
	}
	
}
