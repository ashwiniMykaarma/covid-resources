package covidresources.model.dto;

import java.io.Serializable;

public class EssentialDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type;
	ContactInformationDTO contactInformation;
	String description;
	String name;
	String UUID;
	
	public EssentialDTO() {
		super();
	}
	public EssentialDTO(String type, ContactInformationDTO contactInformation, String description, String name,
			String uUID) {
		super();
		this.type = type;
		this.contactInformation = contactInformation;
		this.description = description;
		this.name = name;
		this.UUID = uUID;
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
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	

}
