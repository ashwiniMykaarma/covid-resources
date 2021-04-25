package covidresources.exception;

import java.io.Serializable;
import java.util.List;

import covidresources.enums.ApiErrorEnum;
import covidresources.model.response.ApiError;
import covidresources.model.response.ApiWarning;


public abstract class CovidResourcesAPIException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	private ApiError apiError;
	private List<ApiWarning> warnings;

	public CovidResourcesAPIException() {
	};

	public CovidResourcesAPIException(ApiErrorEnum apiErrorEnum) {
		this.apiError = new ApiError(apiErrorEnum);
	}

	public List<ApiWarning> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<ApiWarning> warnings) {
		this.warnings = warnings;
	}

	public CovidResourcesAPIException(ApiError apiError) {
		this.apiError = apiError;
	}

	public CovidResourcesAPIException(List<ApiWarning> warnings) {
		this.warnings = warnings;
	}

	public ApiError getApiError() {
		return apiError;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}

}
