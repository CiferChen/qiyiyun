package com.zhidian.server.model.input;

public class AddUpdataArea extends StandardInput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -977108970105772393L;
	
	private Input input;
	
	public static class Input{
		private String loginId;
		private String areaId;
		private String spaceId;
		private String areaName;
		private String areaDescription;
		private String areaImg;
		private String areaLeaderId;
		
		public String getLoginId() {
			return loginId;
		}
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		public String getAreaId() {
			return areaId;
		}
		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}
		public String getSpaceId() {
			return spaceId;
		}
		public void setSpaceId(String spaceId) {
			this.spaceId = spaceId;
		}
		public String getAreaName() {
			return areaName;
		}
		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
		public String getAreaDescription() {
			return areaDescription;
		}
		public void setAreaDescription(String areaDescription) {
			this.areaDescription = areaDescription;
		}
		public String getAreaImg() {
			return areaImg;
		}
		public void setAreaImg(String areaImg) {
			this.areaImg = areaImg;
		}
		public String getAreaLeaderId() {
			return areaLeaderId;
		}
		public void setAreaLeaderId(String areaLeaderId) {
			this.areaLeaderId = areaLeaderId;
		}
		
		
		
	}

	public Input getInput() {
		return input;
	}

	public void setInput(Input input) {
		this.input = input;
	}
	
}
