package com.zhidian.server.model.input;

import java.io.Serializable;

public class StandardInput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9168231737443581180L;
	
	public String fn;

	public String getFn() {
		return fn;
	}

	public void setFn(String fn) {
		this.fn = fn;
	}
	
	
	
}
