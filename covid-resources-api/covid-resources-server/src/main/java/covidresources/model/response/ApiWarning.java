package covidresources.model.response;

import java.io.Serializable;

public class ApiWarning implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private String code;

	private String description;
	
	public ApiWarning(String warningCode, String warningDescription) {
		super();
		this.code = warningCode;
		this.description = warningDescription;
	}
	
	public ApiWarning() {} ;

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
