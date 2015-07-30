package com.zhidian.server.model.input;

public class StandardInputWithLoginId extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4501763932376335028L;

	private Input input;
	
	public class Input{
		private String loginId;

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
