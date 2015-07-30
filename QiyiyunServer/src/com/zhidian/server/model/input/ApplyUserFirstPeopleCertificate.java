package com.zhidian.server.model.input;

public class ApplyUserFirstPeopleCertificate extends StandardInput {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8366108407503210771L;

	public Input Input;

	public Input getInput() {
		return Input;
	}

	public void setInput(Input input) {
		Input = input;
	}

	public static class Input {
		public String LoginID;
		public String PeopleName;
		public int PeopleCredentialType;
		public String PeopleCredentialNumb;
		public String CertificateDoc;

		public String getLoginID() {
			return LoginID;
		}

		public void setLoginID(String loginID) {
			LoginID = loginID;
		}

		public String getPeopleName() {
			return PeopleName;
		}

		public void setPeopleName(String peopleName) {
			PeopleName = peopleName;
		}

		public int getPeopleCredentialType() {
			return PeopleCredentialType;
		}

		public void setPeopleCredentialType(int peopleCredentialType) {
			PeopleCredentialType = peopleCredentialType;
		}

		public String getPeopleCredentialNumb() {
			return PeopleCredentialNumb;
		}

		public void setPeopleCredentialNumb(String peopleCredentialNumb) {
			PeopleCredentialNumb = peopleCredentialNumb;
		}

		public String getCertificateDoc() {
			return CertificateDoc;
		}

		public void setCertificateDoc(String certificateDoc) {
			CertificateDoc = certificateDoc;
		}

	}

}
