package com.zhidian.server.model.input;

public class GetUserOrganListByTypeInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8564211891587965804L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private int getOrganType;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public int getGetOrganType() {
			return getOrganType;
		}
		public void setGetOrganType(int getOrganType) {
			this.getOrganType = getOrganType;
		}
		
		
	}
	
	
	
	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
