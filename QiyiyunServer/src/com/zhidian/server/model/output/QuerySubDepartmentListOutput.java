package com.zhidian.server.model.output;

import java.util.List;

public class QuerySubDepartmentListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6357943949289127192L;
	
	private List<Output> output;
	

	
	public static class Output{
		private String departmentId;
		private String departmentName;
		private String organId;
		private String departmentDesc;
		private String departmentLeaderId;
		private String departmentCreatorId;
		private String departmentCreateTime;
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
		public String getDepartmentCreatorId() {
			return departmentCreatorId;
		}
		public void setDepartmentCreatorId(String departmentCreatorId) {
			this.departmentCreatorId = departmentCreatorId;
		}
		public String getDepartmentCreateTime() {
			return departmentCreateTime;
		}
		public void setDepartmentCreateTime(String departmentCreateTime) {
			this.departmentCreateTime = departmentCreateTime;
		}
		
	}



	public List<Output> getOutput() {
		return output;
	}



	public void setOutput(List<Output> output) {
		this.output = output;
	}
}
