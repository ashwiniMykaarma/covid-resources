package covidresources.model.response;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable{
	

	private static final long serialVersionUID = 1L;

	private Integer statusCode;
	private ApiError error = null;
	private List<ApiWarning> warnings = null;

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}

	public List<ApiWarning> getWarnings() {
		return warnings;
	}

	public void setWarnings(List<ApiWarning> warnings) {
		this.warnings = warnings;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

}
