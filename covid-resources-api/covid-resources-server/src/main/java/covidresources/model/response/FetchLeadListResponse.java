package covidresources.model.response;

import java.util.List;

import covidresources.model.dto.LeadDTO;

public class FetchLeadListResponse extends Response{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<LeadDTO> leadList;
	
	public FetchLeadListResponse() {
		super();
	}

	public FetchLeadListResponse(List<LeadDTO> leadList) {
		super();
		this.leadList = leadList;
	}
	
	public List<LeadDTO> getLead() {
		return leadList;
	}

	public void setLead(List<LeadDTO> leadList) {
		this.leadList = leadList;
	}

}
