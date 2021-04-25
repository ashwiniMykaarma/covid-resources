package covidresources.model.dto;

import java.io.Serializable;

public class LeadDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String state;
	EssentialDTO essential;
	String UUID;
	
	public LeadDTO() {
		super();
	}
	
	public LeadDTO(String state, EssentialDTO essential, String uUID) {
		super();
		this.state = state;
		this.essential = essential;
		UUID = uUID;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public EssentialDTO getEssential() {
		return essential;
	}
	public void setEssential(EssentialDTO essential) {
		this.essential = essential;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	
	
}
