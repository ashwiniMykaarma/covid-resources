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
	
	public UserDTO(String name, ContactInformationDTO contactInformation, String uUID) {
		super();
		this.name = name;
		this.contactInformation = contactInformation;
		UUID = uUID;
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

}
