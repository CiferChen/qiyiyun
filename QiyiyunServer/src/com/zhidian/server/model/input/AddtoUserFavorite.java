package com.zhidian.server.model.input;

public class AddtoUserFavorite extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541974575933210646L;

	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		
		public String LoginID;
		public String ServiceNumb;
		public String getLoginID() {
			return LoginID;
		}
		public void setLoginID(String loginID) {
			LoginID = loginID;
		}
		public String getServiceNumb() {
			return ServiceNumb;
		}
		public void setServiceNumb(String serviceNumb) {
			ServiceNumb = serviceNumb;
		}
		
		
	}
	
}
