package covidresources.model.response;

import covidresources.model.dto.LeadDTO;

public class FetchLeadResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LeadDTO lead;
	
	public FetchLeadResponse() {
		super();
	}

	public FetchLeadResponse(LeadDTO lead) {
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
