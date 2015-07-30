package com.zhidian.server.model.output;

public class GetUserPeopleInfo extends StandardOutput {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7787267414744499646L;

	public Output Output;

	public Output getOutput() {
		return Output;
	}

	public void setOutput(Output output) {
		Output = output;
	}

	public static class Output {

		public String PeopleName;
		public int CredentialType;
		public String CredentialNumb;
		public String PhoneNumb;
		public String Email;

		public String getPeopleName() {
			return PeopleName;
		}

		public void setPeopleName(String peopleName) {
			PeopleName = peopleName;
		}

		public int getCredentialType() {
			return CredentialType;
		}

		public void setCredentialType(int credentialType) {
			CredentialType = credentialType;
		}

		public String getCredentialNumb() {
			return CredentialNumb;
		}

		public void setCredentialNumb(String credentialNumb) {
			CredentialNumb = credentialNumb;
		}

		public String getPhoneNumb() {
			return PhoneNumb;
		}

		public void setPhoneNumb(String phoneNumb) {
			PhoneNumb = phoneNumb;
		}

		public String getEmail() {
			return Email;
		}

		public void setEmail(String email) {
			Email = email;
		}

	}

}
