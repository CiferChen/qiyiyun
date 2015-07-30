package com.zhidian.server.model.output;

public class QueryBookStationOutput extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -22665699186429827L;
	
	private Output output;
	
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

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
}
