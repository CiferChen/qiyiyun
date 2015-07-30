package com.zhidian.server.model.output;

public class QueryOrganCertificationDetailOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 539461139778222732L;
	
	private Output output;
	
	public static class Output{
		private String certificationId;
		private String certificationTypeId;
		private int certificationObject;
		private String certificationName;
		private String certificationNumber;
		private String certificationImg;
		private int certificationStatus;
		
		public String getCertificationId() {
			return certificationId;
		}
		public void setCertificationId(String certificationId) {
			this.certificationId = certificationId;
		}
		public String getCertificationTypeId() {
			return certificationTypeId;
		}
		public void setCertificationTypeId(String certificationTypeId) {
			this.certificationTypeId = certificationTypeId;
		}
		public int getCertificationObject() {
			return certificationObject;
		}
		public void setCertificationObject(int certificationObject) {
			this.certificationObject = certificationObject;
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
		public String getCertificationImg() {
			return certificationImg;
		}
		public void setCertificationImg(String certificationImg) {
			this.certificationImg = certificationImg;
		}
		public int getCertificationStatus() {
			return certificationStatus;
		}
		public void setCertificationStatus(int certificationStatus) {
			this.certificationStatus = certificationStatus;
		}
		
		
		
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
}
