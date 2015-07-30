package com.zhidian.server.model.input;

public class QueryDelRegisteredSpaceInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401249690062482673L;
	
	private Input input;
	
	public static class Input{
		
		private String loginId;
		private String registeredSpaceId;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getRegisteredSpaceId() {
			return registeredSpaceId;
		}
		public void setRegisteredSpaceId(String registeredSpaceId) {
			this.registeredSpaceId = registeredSpaceId;
		}
		
		
	
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
