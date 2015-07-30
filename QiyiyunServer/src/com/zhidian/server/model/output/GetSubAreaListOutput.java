package com.zhidian.server.model.output;

import java.util.List;

public class GetSubAreaListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4195287928712891622L;
	
	private List<Output> output;
	
	public static class Output{
		private String areaId;
		private String areaName;
		private String spaceName;
		public String getAreaId() {
			return areaId;
		}
		public void setAreaId(String areaId) {
			this.areaId = areaId;
		}
		public String getAreaName() {
			return areaName;
		}
		public void setAreaName(String areaName) {
			this.areaName = areaName;
		}
		public String getSpaceName() {
			return spaceName;
		}
		public void setSpaceName(String spaceName) {
			this.spaceName = spaceName;
		}
		
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
