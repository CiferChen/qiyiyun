package com.zhidian.server.model.input;

public class UpdateUserPeopleInfo extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3388406445876659489L;

	public Input Input;
	
	public static class Input{
		public String LoginID;
		public String PeopleName;
		public String PhoneNumb;
		public String Email;
		public String getLoginID() {
			return LoginID;
		}
		public void setLoginID(String loginID) {
			LoginID = loginID;
		}
		public String getPeopleName() {
			return PeopleName;
		}
		public void setPeopleName(String peopleName) {
			PeopleName = peopleName;
		}
		public String getPhoneNumb() {
			return PhoneNumb;
		}
		public void setPhoneNumb(String phoneNumb) {
			PhoneNumb = phoneNumb;
		}
		public String getEmail() {
			return Email;
		}
		public void setEmail(String email) {
			Email = email;
		}
		
		
	}
	
}
