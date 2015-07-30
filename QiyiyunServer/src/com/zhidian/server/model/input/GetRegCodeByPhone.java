package com.zhidian.server.model.input;

public class GetRegCodeByPhone extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 927914072637044689L;

	public Input Input;
	
	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input{
		public String PhoneNumb;

		public String getPhoneNumb() {
			return PhoneNumb;
		}

		public void setPhoneNumb(String phoneNumb) {
			PhoneNumb = phoneNumb;
		}
		
		
	}
	
}
