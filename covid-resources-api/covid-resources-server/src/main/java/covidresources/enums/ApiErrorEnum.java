package covidresources.enums;

public enum ApiErrorEnum {
	
	//Generic error codes
	EMPTY_REQUEST("request is null or empty"),
	EMPTY_UUID("UUID is null or empty"),
	INVALID_STATE("Invalid state"),
	INVALID_UUID("UUID is null or empty"),
	NO_LEAD_CORRESPONDING_TO_UUID("No lead found corresponding to UUID"),
	INVALID_TYPE("Invalid type"),
	INVALID_NAME("Please provide a name for the lead"),
	NO_CONTACT("One phone number is a must for a lead"),
	
	INVALID_LEADUUID("UUID of the lead to be verified is not present"),
	INVALID_USERUUID("UUID of the user to be verified is not present"),
	NO_USER_CORRESPONDING_TO_UUID("No user found corresponding to UUID"),
	USER_IS_NOT_AUTHORISED_TO_VERIFY("User is not authorised to verify an item"),
	
	INVALID_USER_NAME("Please give a proper name for the user"),
	INVALID_USER_EMAIL("User email is mandatory, please provide email address");
	
	public String value ;

	private ApiErrorEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
