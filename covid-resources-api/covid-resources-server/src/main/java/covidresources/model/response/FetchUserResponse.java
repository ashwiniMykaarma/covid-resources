package covidresources.model.response;

import covidresources.model.dto.UserDTO;

public class FetchUserResponse extends Response{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDTO user;
	
	public FetchUserResponse() {
		super();
	}

	public FetchUserResponse(UserDTO user) {
		super();
		this.user = user;
	}
	
	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
