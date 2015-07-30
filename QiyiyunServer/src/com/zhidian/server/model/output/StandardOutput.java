package com.zhidian.server.model.output;

import java.io.Serializable;

public class StandardOutput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -416105182448036824L;

	public String fn;
	
	public int Result;

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}

	public int getResult() {
		return Result;
	}

	public void setResult(int result) {
		Result = result;
	}
	
}
