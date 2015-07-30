package com.zhidian.server.model.input;

public class ModUserPsdInput extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2335888152068004106L;

	private Input input;



	public static class Input {
		private String loginId;
		private String oldPsd;
		private String newPsd;
		
		public String getOldPsd() {
			return oldPsd;
		}
		public void setOldPsd(String oldPsd) {
			this.oldPsd = oldPsd;
		}
		public String getNewPsd() {
			return newPsd;
		}
		public void setNewPsd(String newPsd) {
			this.newPsd = newPsd;
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
