package covidresources.model.dto;

import java.io.Serializable;

public class LeadDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String state;
	String type;
	ContactInformationDTO contactInformation;
	String description;
	String name;
	String UUID;
	
	public LeadDTO() {
		super();
	}
	
	public LeadDTO(String state, String type, ContactInformationDTO contactInformation, String description, String name,
			String uUID) {
		super();
		this.state = state;
		this.type = type;
		this.contactInformation = contactInformation;
		this.description = description;
		this.name = name;
		UUID = uUID;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ContactInformationDTO getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformationDTO contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
