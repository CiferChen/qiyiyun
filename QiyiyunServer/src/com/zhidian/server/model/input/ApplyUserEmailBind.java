package com.zhidian.server.model.input;

public class ApplyUserEmailBind extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8677353029090543345L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String EmailAddr;
		public String BindUrl;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getEmailAddr() {
			return EmailAddr;
		}

		public void setEmailAddr(String emailAddr) {
			EmailAddr = emailAddr;
		}

		public String getBindUrl() {
			return BindUrl;
		}

		public void setBindUrl(String bindUrl) {
			BindUrl = bindUrl;
		}

	}

}
