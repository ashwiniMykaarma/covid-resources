package covidresources.model.response;

public class SaveUserResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String userUUID;
	
	public SaveUserResponse() {
		super();
	}

	public SaveUserResponse(String userUUID) {
		super();
		this.userUUID = userUUID;
	}

	public String getUserUuid() {
		return userUUID;
	}

	public void setUserUuid(String userUUID) {
		this.userUUID = userUUID;
	}
	

}
