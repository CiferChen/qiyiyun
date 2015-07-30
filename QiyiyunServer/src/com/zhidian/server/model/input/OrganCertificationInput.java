package com.zhidian.server.model.input;

public class OrganCertificationInput extends StandardInput{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 291811673066456182L;
	private Input input;
	
	public static class Input{
		
		private String loginId;
		private String certificationId;
		private String organId;
		private String certificationTypeId;
		private String certificationName;
		private String certificationNumber;
		private String certificationImg;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getCertificationTypeId() {
			return certificationTypeId;
		}
		public void setCertificationTypeId(String certificationTypeId) {
			this.certificationTypeId = certificationTypeId;
		}


		
		public String getCertificationImg() {
			return certificationImg;
		}
		public void setCertificationImg(String certificationImg) {
			this.certificationImg = certificationImg;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getCertificationId() {
			return certificationId;
		}
		public void setCertificationId(String certificationId) {
			this.certificationId = certificationId;
		}
		public String getCertificationName() {
			return certificationName;
		}
		public void setCertificationName(String certificationName) {
			this.certificationName = certificationName;
		}
		public String getCertificationNumber() {
			return certificationNumber;
		}
		public void setCertificationNumber(String certificationNumber) {
			this.certificationNumber = certificationNumber;
		}
		
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
}
