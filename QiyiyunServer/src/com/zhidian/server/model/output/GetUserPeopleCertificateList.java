package com.zhidian.server.model.output;

import java.util.List;

public class GetUserPeopleCertificateList extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1391551233328559700L;

	public List<Output> Output;

	public List<Output> getOutput() {
		return Output;
	}

	public void setOutput(List<Output> output) {
		Output = output;
	}

	public static class Output {
		public int CertificateType;
		public int CertificateState;

		public int getCertificateType() {
			return CertificateType;
		}

		public void setCertificateType(int certificateType) {
			CertificateType = certificateType;
		}

		public int getCertificateState() {
			return CertificateState;
		}

		public void setCertificateState(int certificateState) {
			CertificateState = certificateState;
		}

	}

}
