package com.zhidian.server.configuration;

public class ResultWithFN {
	private String fn;
	private String message;
	
	public ResultWithFN() {
	}

	public ResultWithFN(String fn,String message) {
		this.fn = fn;
		this.message = message;
	}
	
	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
