package com.zhidian.server.model.output;

import java.util.List;

public class GetOrganRightListOutput extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = -497785554767014131L;
	
	private List<Output> output;
	
	
	public static class Output{
		
		private String rightId;
		private String rightName;
		private int rightType;
		private String rightDescription;
		public String getRightId() {
			return rightId;
		}
		public void setRightId(String rightId) {
			this.rightId = rightId;
		}
		public String getRightName() {
			return rightName;
		}
		public void setRightName(String rightName) {
			this.rightName = rightName;
		}
		public int getRightType() {
			return rightType;
		}
		public void setRightType(int rightType) {
			this.rightType = rightType;
		}
		public String getRightDescription() {
			return rightDescription;
		}
		public void setRightDescription(String rightDescription) {
			this.rightDescription = rightDescription;
		}
		
		
		
	}


	public List<Output> getOutput() {
		return output;
	}


	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
