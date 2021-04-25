package covidresources.model.dto;

import java.io.Serializable;
import java.util.Date;

public class VerificationDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String leadUUID;
	String userUUID;
	Date insertTS;
	Boolean isAvailable;
	String UUID;
	
	public VerificationDTO() {
		super();
	}
	
	public VerificationDTO(String leadUUID, String userUUID, Date insertTS, Boolean isAvailable, String uUID) {
		super();
		this.leadUUID = leadUUID;
		this.userUUID = userUUID;
		this.insertTS = insertTS;
		this.isAvailable = isAvailable;
		UUID = uUID;
	}
	
	public String getLeadUUID() {
		return leadUUID;
	}

	public void setLeadUUID(String leadUUID) {
		this.leadUUID = leadUUID;
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
	
	public Boolean getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String uUID) {
		UUID = uUID;
	}

}
