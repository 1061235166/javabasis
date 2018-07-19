package com.k.jdk.bio;

import java.util.Map;

/**
 * created by k
 * 2018/6/15
 **/
public class HttpResponse {
	private String fisrtLine="HTTP/1.1 200 OK";
	private Map<String,String>headers;

	public String getFisrtLine() {
		return fisrtLine;
	}

	public void setFisrtLine(String fisrtLine) {
		this.fisrtLine = fisrtLine;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}
}
