package covidresources.enums;

public enum ApiErrorEnum {
	
	//Generic error codes
	EMPTY_REQUEST("request is null or empty"),
	EMPTY_UUID("UUID is null or empty");
	
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
