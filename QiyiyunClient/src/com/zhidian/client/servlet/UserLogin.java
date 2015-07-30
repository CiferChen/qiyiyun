package com.zhidian.client.servlet;

public class UserLogin extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4391184326095337978L;

	public Output output;
	
	public Output getOutput() {
		return output;
	}
	
	public void setOutput(Output output) {
		this.output = output;
	}

	public static class Output{
		public String loginID;

		public String getLoginID() {
			return loginID;
		}

		public void setLoginID(String loginID) {
			this.loginID = loginID;
		}
	}
	
}
