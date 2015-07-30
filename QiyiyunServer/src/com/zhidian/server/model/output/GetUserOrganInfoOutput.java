package com.zhidian.server.model.output;

public class GetUserOrganInfoOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1868490308379800987L;
	
	private Output output;
	
	public static class Output{
		private String organId;
		private String organName;
		private String creatTime;
		private String createrId;
		private String createrName;
		private String organDesc;
		private String organAddreass;
		private String organTypeId;
		private String organTypeName;
		private String contactName;
		private String contactPhone;
		private String contactEmail;
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getOrganName() {
			return organName;
		}
		public void setOrganName(String organName) {
			this.organName = organName;
		}
		public String getCreatTime() {
			return creatTime;
		}
		public void setCreatTime(String creatTime) {
			this.creatTime = creatTime;
		}
		public String getCreaterId() {
			return createrId;
		}
		public void setCreaterId(String createrId) {
			this.createrId = createrId;
		}
		public String getCreaterName() {
			return createrName;
		}
		public void setCreaterName(String createrName) {
			this.createrName = createrName;
		}
		public String getOrganDesc() {
			return organDesc;
		}
		public void setOrganDesc(String organDesc) {
			this.organDesc = organDesc;
		}
		public String getOrganAddreass() {
			return organAddreass;
		}
		public void setOrganAddreass(String organAddreass) {
			this.organAddreass = organAddreass;
		}
		public String getOrganTypeId() {
			return organTypeId;
		}
		public void setOrganTypeId(String organTypeId) {
			this.organTypeId = organTypeId;
		}
		public String getOrganTypeName() {
			return organTypeName;
		}
		public void setOrganTypeName(String organTypeName) {
			this.organTypeName = organTypeName;
		}
		public String getContactName() {
			return contactName;
		}
		public void setContactName(String contactName) {
			this.contactName = contactName;
		}
		public String getContactPhone() {
			return contactPhone;
		}
		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}
		public String getContactEmail() {
			return contactEmail;
		}
		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}
		
		
		
		
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
	
}
