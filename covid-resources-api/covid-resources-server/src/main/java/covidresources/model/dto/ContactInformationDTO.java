package covidresources.model.dto;

import java.io.Serializable;
import java.util.List;

public class ContactInformationDTO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> phoneNumber;
	List<String> emailAddress;
	String address;
	Double latitude;
	Double longitude;
	
	public ContactInformationDTO() {
		super();
	}
	public ContactInformationDTO(List<String> phoneNumber, List<String> emailAddress, String address, Double latitude,
			Double longitude) {
		super();
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public List<String> getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(List<String> phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public List<String> getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(List<String> emailAddress) {
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
