package com.zhidian.server.model.output;

import java.util.List;

public class GetVisitorList extends StandardOutput{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3864864791814661340L;
	
	private List<Output> output;

	public static class Output{
		private String visitorId;
		private String visitorName;
		private String visitorStartTime;
		private String organId;
		public String getVisitorId() {
			return visitorId;
		}
		public void setVisitorId(String visitorId) {
			this.visitorId = visitorId;
		}
		public String getVisitorName() {
			return visitorName;
		}
		public void setVisitorName(String visitorName) {
			this.visitorName = visitorName;
		}
		public String getVisitorStartTime() {
			return visitorStartTime;
		}
		public void setVisitorStartTime(String visitorStartTime) {
			this.visitorStartTime = visitorStartTime;
		}
		public String getOrganId() {
			return organId;
		}
		public void setOrganId(String organId) {
			this.organId = organId;
		}
		
		
	}

	public List<Output> getOutput() {
		return output;
	}

	public void setOutput(List<Output> output) {
		this.output = output;
	}
	
}
