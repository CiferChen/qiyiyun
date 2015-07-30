package com.zhidian.server.model.output;

import java.util.List;

public class GetOrganAccountRecordListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5397139512729120317L;

	private List<Output> output ;
	
	
	public static class Output{
		
		private String accountRecordId;
		private String organId;
		private String operatorId;
		private String operateTime;
		private String operateReason;
		private String operateWay;
		private String operateCount;
		private String operateType;
		
		public String getAccountRecordId() {
			return accountRecordId;
		}
		public void setAccountRecordId(String accountRecordId) {
			this.accountRecordId = accountRecordId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getOperatorId() {
			return operatorId;
		}
		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}
		public String getOperateTime() {
			return operateTime;
		}
		public void setOperateTime(String operateTime) {
			this.operateTime = operateTime;
		}
		public String getOperateReason() {
			return operateReason;
		}
		public void setOperateReason(String operateReason) {
			this.operateReason = operateReason;
		}
		public String getOperateWay() {
			return operateWay;
		}
		public void setOperateWay(String operateWay) {
			this.operateWay = operateWay;
		}
		public String getOperateCount() {
			return operateCount;
		}
		public void setOperateCount(String operateCount) {
			this.operateCount = operateCount;
		}
		public String getOperateType() {
			return operateType;
		}
		public void setOperateType(String operateType) {
			this.operateType = operateType;
		}
		
	}


	public List<Output> getOutput() {
		return output;
	}


	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
	
}
