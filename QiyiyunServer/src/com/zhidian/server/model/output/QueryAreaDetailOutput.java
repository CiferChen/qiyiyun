package com.zhidian.server.model.output;

public class QueryAreaDetailOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4811609168997090480L;
	
	private Output output;
	
	public static class Output{
		private String areaName;
		private String spaceId;
		private String areaDescription;
		private String areaImg;
		private String areaLeaderId;
		
		public String getAreaName() {
			return areaName;
		}
		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
		public String getSpaceId() {
			return spaceId;
		}
		public void setSpaceId(String spaceId) {
			this.spaceId = spaceId;
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

	public Output getOutput() {
		return output;
	}

	public void setOutput(Output output) {
		this.output = output;
	}
	
}
