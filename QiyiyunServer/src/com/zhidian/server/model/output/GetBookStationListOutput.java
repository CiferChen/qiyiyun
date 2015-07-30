package com.zhidian.server.model.output;

import java.util.List;

public class GetBookStationListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2636306621204315483L;
	
	private List<Output> output;
	
	public static class Output{
		private String bookStationId;
		private String bookStationName;
		private String bookStationPhone;
		private String bookStationEmail;
		public String getBookStationId() {
			return bookStationId;
		}
		public void setBookStationId(String bookStationId) {
			this.bookStationId = bookStationId;
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
		
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
