package com.zhidian.server.model.input;

public class BindUserEmail extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1249307271798878486L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String EmailAddr;
		public String BindCode;
		public String UserName;

		public String getEmailAddr() {
			return EmailAddr;
		}

		public void setEmailAddr(String emailAddr) {
			EmailAddr = emailAddr;
		}

		public String getBindCode() {
			return BindCode;
		}

		public void setBindCode(String bindCode) {
			BindCode = bindCode;
		}

		public String getUserName() {
			return UserName;
		}

		public void setUserName(String userName) {
			UserName = userName;
		}

	}

}
