package com.zhidian.server.model.input;

public class CompltRegByPhone extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7098398748352240609L;

	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		public String UserName;
		public String PhoneNumb;
		public String Password;
		public String RegCode;
		public String getUserName() {
			return UserName;
		}
		public void setUserName(String userName) {
			UserName = userName;
		}
		public String getPhoneNumb() {
			return PhoneNumb;
		}
		public void setPhoneNumb(String phoneNumb) {
			PhoneNumb = phoneNumb;
		}
		public String getPassword() {
			return Password;
		}
		public void setPassword(String password) {
			Password = password;
		}
		public String getRegCode() {
			return RegCode;
		}
		public void setRegCode(String regCode) {
			RegCode = regCode;
		}
		
		
	}
	
}
