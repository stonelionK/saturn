package com.kt.conv.robotvtf.qat.service.ny;

import com.kt.conv.robotvtf.qat.entity.Auth;

public interface Repository {
	
	abstract boolean connect(Auth auth);
	abstract boolean download(String url);
	abstract boolean upload();

}
