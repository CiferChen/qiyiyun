package com.zhidian.server.model.output;

import java.util.List;

public class GetUserApplyToOrganOutput extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4233710969509561600L;

	private List<Output> output;
	
	public static class Output{
		private String memberRelRecordId;
		private String memberId;
		private String organId;
		private int recordDirection;
		private int recordStatus;
		private String recordCreateTime;
		
		public String getMemberRelRecordId() {
			return memberRelRecordId;
		}
		public void setMemberRelRecordId(String memberRelRecordId) {
			this.memberRelRecordId = memberRelRecordId;
		}
		public String getMemberId() {
			return memberId;
		}
		public void setMemberId(String memberId) {
			this.memberId = memberId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
	
		public String getRecordCreateTime() {
			return recordCreateTime;
		}
		public void setRecordCreateTime(String recordCreateTime) {
			this.recordCreateTime = recordCreateTime;
		}
		public int getRecordDirection() {
			return recordDirection;
		}
		public void setRecordDirection(int recordDirection) {
			this.recordDirection = recordDirection;
		}
		public int getRecordStatus() {
			return recordStatus;
		}
		public void setRecordStatus(int recordStatus) {
			this.recordStatus = recordStatus;
		}
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}


	
}
