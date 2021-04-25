package covidresources.exception;

import covidresources.enums.ApiErrorEnum;
import covidresources.model.response.ApiError;

public class ValidationException extends CovidResourcesAPIException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidationException(ApiError apiError){
		super(apiError) ;
	}
	
	public ValidationException(ApiErrorEnum apiErrorEnum){
		super(apiErrorEnum) ;
	}

}
