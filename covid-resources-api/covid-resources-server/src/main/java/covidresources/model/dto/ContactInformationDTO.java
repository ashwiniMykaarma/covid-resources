package covidresources.model.dto;

import java.io.Serializable;

public class ContactInformationDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String phoneNumber;
	String emailAddress;
	String address;
	Double latitude;
	Double longitude;
	
	public ContactInformationDTO() {
		super();
	}
	public ContactInformationDTO(String phoneNumber, String emailAddress, String address, Double latitude,
			Double longitude) {
		super();
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

}
