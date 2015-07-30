package com.zhidian.client.servlet;

import java.io.Serializable;

public class StandardOutput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -416105182448036824L;

	public String fn;
	
	public int result;

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
}
