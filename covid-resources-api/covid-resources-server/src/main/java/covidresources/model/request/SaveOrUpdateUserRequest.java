package covidresources.model.request;

import java.io.Serializable;

import covidresources.model.dto.UserDTO;

public class SaveOrUpdateUserRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	UserDTO user;
	
	public SaveOrUpdateUserRequest() {
		super();
	}

	public SaveOrUpdateUserRequest(UserDTO user) {
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
