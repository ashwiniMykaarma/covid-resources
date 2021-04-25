package covidresources.model.dto;

import java.io.Serializable;
import java.util.Date;

public class VerificationDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String essentialUUID;
	String userUUID;
	Date insertTS;
	
	public VerificationDTO() {
		super();
	}
	
	public VerificationDTO(String essentialUUID, String userUUID, Date insertTS) {
		super();
		this.essentialUUID = essentialUUID;
		this.userUUID = userUUID;
		this.insertTS = insertTS;
	}
	
	public String getEssentialUUID() {
		return essentialUUID;
	}

	public void setEssentialUUID(String essentialUUID) {
		this.essentialUUID = essentialUUID;
	}

	public String getUserUUID() {
		return userUUID;
	}

	public void setUserUUID(String userUUID) {
		this.userUUID = userUUID;
	}

	public Date getInsertTS() {
		return insertTS;
	}

	public void setInsertTS(Date insertTS) {
		this.insertTS = insertTS;
	}

}
