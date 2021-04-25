package covidresources.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import covidresources.enums.ApiErrorEnum;
import covidresources.exception.ValidationException;
import covidresources.model.request.FetchLeadsRequest;
import covidresources.model.request.SaveOrUpdateLeadRequest;
import covidresources.model.response.FetchLeadListResponse;

@Service("LeadsValidator")
public class LeadsValidator {
	
	public void validateLeadsSaveRequest(SaveOrUpdateLeadRequest request) throws Exception{
		
		if(request == null) {
			
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
			
		}
		
	}
	
	public void validateLeadsUpdateRequest(SaveOrUpdateLeadRequest request) throws Exception{
		
		if(request == null) {
			
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
			
		}
		
	}
	
	public void validateLeadsFetchRequest(String leadUuid) throws Exception{
		
		if(StringUtils.isEmpty(leadUuid)) {
			
			throw new ValidationException(ApiErrorEnum.EMPTY_UUID);
			
		}
		
	}
	
	public void validateLeadsListFetchRequest(FetchLeadsRequest request) throws Exception{
		
		if(request == null) {
			
			throw new ValidationException(ApiErrorEnum.EMPTY_UUID);
			
		}
		
	}
	
	

}
