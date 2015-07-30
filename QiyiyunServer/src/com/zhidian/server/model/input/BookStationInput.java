package com.zhidian.server.model.input;

public class BookStationInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8951771899526895802L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String bookStationId;
		private String bookStationName;
		private String bookStationPhone;
		private String bookStationEmail;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getBookStationName() {
			return bookStationName;
		}
		public void setBookStationName(String bookStationName) {
			this.bookStationName = bookStationName;
		}
		public String getBookStationPhone() {
			return bookStationPhone;
		}
		public void setBookStationPhone(String bookStationPhone) {
			this.bookStationPhone = bookStationPhone;
		}
		public String getBookStationEmail() {
			return bookStationEmail;
		}
		public void setBookStationEmail(String bookStationEmail) {
			this.bookStationEmail = bookStationEmail;
		}
		public String getBookStationId() {
			return bookStationId;
		}
		public void setBookStationId(String bookStationId) {
			this.bookStationId = bookStationId;
		}
		
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
	
}
