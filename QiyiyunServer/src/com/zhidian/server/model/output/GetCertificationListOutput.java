package com.zhidian.server.model.output;

import java.util.List;

public class GetCertificationListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6117625510483742373L;
	
	private List<Output> output;
	
	public static class Output{
		private String certificationId;
		private String certificationTypeId;
		private String relationId;
		private String certificationName;
		private String certificationNumber;
		private String certificationImg;
		private String certificationStatus;
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
		public String getCertificationStatus() {
			return certificationStatus;
		}
		public void setCertificationStatus(String certificationStatus) {
			this.certificationStatus = certificationStatus;
		}
		public String getRelationId() {
			return relationId;
		}
		public void setRelationId(String relationId) {
			this.relationId = relationId;
		}
		
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
