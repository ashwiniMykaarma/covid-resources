package covidresources.model.response;

import java.io.Serializable;
import java.util.HashMap;

import covidresources.enums.ApiErrorEnum;

public class ApiError implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;

	private String description;

	private HashMap<String, String> metadata;

	public ApiError() {
	};

	public ApiError(ApiErrorEnum errorEnum) {
		this.code = errorEnum.name();
		this.description = errorEnum.getValue();
	}

	public ApiError(String errorCode, String errorDescription) {
		this.code = errorCode;
		this.description = errorDescription;
	}

	public ApiError(String errorCode, String errorDescription, HashMap<String, String> metadata) {
		super();
		this.code = errorCode;
		this.description = errorDescription;
		this.metadata = metadata;
	}

	public HashMap<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(HashMap<String, String> metadata) {
		this.metadata = metadata;
	}

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

