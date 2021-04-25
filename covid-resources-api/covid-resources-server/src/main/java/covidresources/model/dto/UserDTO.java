package covidresources.model.dto;

import java.io.Serializable;

import covidresources.model.documents.ContactInformation;

public class UserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String name;
	ContactInformationDTO contactInformation;
	String UUID;
	Boolean hasAuthorityToVerify;
	
	public UserDTO(String name, ContactInformationDTO contactInformation, String uUID, Boolean hasAuthorityToVerify) {
		super();
		this.name = name;
		this.contactInformation = contactInformation;
		this.UUID = uUID;
		this.hasAuthorityToVerify = hasAuthorityToVerify;
	}
	public UserDTO() {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ContactInformationDTO getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(ContactInformationDTO contactInformation) {
		this.contactInformation = contactInformation;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public Boolean getHasAuthorityToVerify() {
		return hasAuthorityToVerify;
	}
	public void setHasAuthorityToVerify(Boolean hasAuthorityToVerify) {
		this.hasAuthorityToVerify = hasAuthorityToVerify;
	}

}
