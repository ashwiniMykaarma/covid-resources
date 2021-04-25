package covidresources.model.request;

import java.io.Serializable;

import covidresources.model.dto.LeadDTO;

public class SaveOrUpdateLeadRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LeadDTO lead;
	
	public SaveOrUpdateLeadRequest() {
		super();
	}

	public SaveOrUpdateLeadRequest(LeadDTO lead) {
		super();
		this.lead = lead;
	}
	
	
	public LeadDTO getLead() {
		return lead;
	}

	public void setLead(LeadDTO lead) {
		this.lead = lead;
	}

}
