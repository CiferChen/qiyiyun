package com.zhidian.server.model.input;

public class AccountInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771129939679906710L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String organId;
		
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		
		
		
	}


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
