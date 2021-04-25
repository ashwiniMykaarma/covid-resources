package covidresources.model.request;

import java.io.Serializable;

import covidresources.model.dto.VerificationDTO;

public class SaveVerificationRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	VerificationDTO verification;
	
	public SaveVerificationRequest() {
		super();
	}

	public SaveVerificationRequest(VerificationDTO verification) {
		super();
		this.verification = verification;
	}

	public VerificationDTO getVerification() {
		return verification;
	}

	public void setVerification(VerificationDTO verification) {
		this.verification = verification;
	}

}
