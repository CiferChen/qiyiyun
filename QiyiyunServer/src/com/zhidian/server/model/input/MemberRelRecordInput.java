package com.zhidian.server.model.input;

public class MemberRelRecordInput extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4339744747320647759L;

	private Input input;
	
	public static class Input{
		private String loginId;
		private String personId;
		private String organId;
		private String memberRelRecordId;
		private int recordStatus;
		
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		public String getMemberRelRecordId() {
			return memberRelRecordId;
		}
		public void setMemberRelRecordId(String memberRelRecordId) {
			this.memberRelRecordId = memberRelRecordId;
		}
		
		public String getPersonId() {
			return personId;
		}
		public void setPersonId(String personId) {
			this.personId = personId;
		}
		public int getRecordStatus() {
			return recordStatus;
		}
		public void setRecordStatus(int recordStatus) {
			this.recordStatus = recordStatus;
		}
		
		
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
