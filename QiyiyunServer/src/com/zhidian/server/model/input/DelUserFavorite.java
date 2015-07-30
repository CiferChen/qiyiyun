package com.zhidian.server.model.input;

public class DelUserFavorite extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6420739655897216601L;

	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		
		public String LoginID;
		public String ServiceNumbInFavorite;
		public String getLoginID() {
			return LoginID;
		}
		public void setLoginID(String loginID) {
			LoginID = loginID;
		}
		public String getServiceNumbInFavorite() {
			return ServiceNumbInFavorite;
		}
		public void setServiceNumbInFavorite(String serviceNumbInFavorite) {
			ServiceNumbInFavorite = serviceNumbInFavorite;
		}
		
		
	}
	
}
