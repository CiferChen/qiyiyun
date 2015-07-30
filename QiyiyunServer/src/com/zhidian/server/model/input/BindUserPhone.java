package com.zhidian.server.model.input;

public class BindUserPhone extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1227650312404808333L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String PhoneNumb;
		public String BindCode;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getPhoneNumb() {
			return PhoneNumb;
		}

		public void setPhoneNumb(String phoneNumb) {
			PhoneNumb = phoneNumb;
		}

		public String getBindCode() {
			return BindCode;
		}

		public void setBindCode(String bindCode) {
			BindCode = bindCode;
		}

	}

}
