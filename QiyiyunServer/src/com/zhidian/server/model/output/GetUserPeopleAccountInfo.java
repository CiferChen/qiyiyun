package com.zhidian.server.model.output;

import java.util.List;

public class GetUserPeopleAccountInfo extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -262153586019950499L;

	public List<Output> Output;

	public List<Output> getOutput() {
		return Output;
	}

	public void setOutput(List<Output> output) {
		Output = output;
	}

	public static class Output {
		public String TransFlowNumb;
		public int InOrOut;
		public int TransType;
		public int TransWay;
		public String TransAmount;
		public String TransRemain;
		public String TransTime;

		public String getTransFlowNumb() {
			return TransFlowNumb;
		}

		public void setTransFlowNumb(String transFlowNumb) {
			TransFlowNumb = transFlowNumb;
		}

		public int getInOrOut() {
			return InOrOut;
		}

		public void setInOrOut(int inOrOut) {
			InOrOut = inOrOut;
		}

		public int getTransType() {
			return TransType;
		}

		public void setTransType(int transType) {
			TransType = transType;
		}

		public int getTransWay() {
			return TransWay;
		}

		public void setTransWay(int transWay) {
			TransWay = transWay;
		}

		public String getTransAmount() {
			return TransAmount;
		}

		public void setTransAmount(String transAmount) {
			TransAmount = transAmount;
		}

		public String getTransRemain() {
			return TransRemain;
		}

		public void setTransRemain(String transRemain) {
			TransRemain = transRemain;
		}

		public String getTransTime() {
			return TransTime;
		}

		public void setTransTime(String transTime) {
			TransTime = transTime;
		}

	}
}
