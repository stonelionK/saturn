package com.kt.conv.robotvtf.qat.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LocalScriptExecutor {
	
	
	public static String runLocalScript(String cmd) throws IOException, InterruptedException {

		Runtime r = Runtime.getRuntime();
		Process p = r.exec(cmd);
		p.waitFor();
		BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = "";
		StringBuilder sb =  new StringBuilder();

		while ((line = b.readLine()) != null) {
			sb.append(line);
		}

		b.close();
		return sb.toString();

	}

	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println(runLocalScript("/qat/a.sh"));
	}

}
