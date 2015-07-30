package com.zhidian.server.model.input;

public class CertificationInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8453552182055262783L;
	
	private Input input;
	
	
	public static class Input{
		private String loginId;
		private int certificationObject;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public int getCertificationObject() {
			return certificationObject;
		}
		public void setCertificationObject(int certificationObject) {
			this.certificationObject = certificationObject;
		}
		
		
	}


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}
	
}
