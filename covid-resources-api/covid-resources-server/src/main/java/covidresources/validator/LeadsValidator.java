package covidresources.validator;

import org.springframework.stereotype.Service;

import covidresources.enums.ApiErrorEnum;
import covidresources.exception.ValidationException;
import covidresources.model.request.SaveLeadRequest;

@Service("LeadsValidator")
public class LeadsValidator {
	
	public void validateLeadsSaveRequest(SaveLeadRequest request) throws Exception{
		
		if(request == null) {
			
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
			
		}
		
	}

}
