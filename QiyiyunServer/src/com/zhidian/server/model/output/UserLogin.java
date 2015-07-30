package com.zhidian.server.model.output;

public class UserLogin extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4391184326095337978L;

	public Output Output;
	
	public Output getOutput() {
		return Output;
	}

	public void setOutput(Output output) {
		Output = output;
	}

	public static class Output{
		public String LoginID;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}
		
		
	}
	
}
