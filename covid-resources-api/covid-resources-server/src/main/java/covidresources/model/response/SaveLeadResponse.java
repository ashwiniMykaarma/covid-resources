package covidresources.model.response;

public class SaveLeadResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String leadUuid;
	
	public SaveLeadResponse() {
		super();
	}
	
	public SaveLeadResponse(String leadUuid) {
		super();
		this.leadUuid = leadUuid;
	}
	
	public String getLeadUuid() {
		return leadUuid;
	}

	public void setLeadUuid(String leadUuid) {
		this.leadUuid = leadUuid;
	}


}
