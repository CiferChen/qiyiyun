package com.zhidian.server.model.input;

public class DepartmentInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4761761964872126125L;
	
	private Input input;
	
	
	public static class Input{
		private String loginId;
		private String departmentId;
		private String departmentName;
		private String organId;
		private String departmentDesc;
		private String departmentLeaderId;
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(String departmentId) {
			this.departmentId = departmentId;
		}
		public String getDepartmentName() {
			return departmentName;
		}
		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getDepartmentDesc() {
			return departmentDesc;
		}
		public void setDepartmentDesc(String departmentDesc) {
			this.departmentDesc = departmentDesc;
		}
		public String getDepartmentLeaderId() {
			return departmentLeaderId;
		}
		public void setDepartmentLeaderId(String departmentLeaderId) {
			this.departmentLeaderId = departmentLeaderId;
		}
		
		
		
		
		
	}


	public Input getInput() {
		return input;
	}


	public void setInput(Input input) {
		this.input = input;
	}
	
}
