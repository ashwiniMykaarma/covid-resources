package covidresources.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import covidresources.enums.ApiErrorEnum;
import covidresources.enums.IndianStates;
import covidresources.exception.ValidationException;
import covidresources.model.documents.Lead;
import covidresources.model.request.FetchLeadsRequest;
import covidresources.model.request.SaveOrUpdateLeadRequest;
import covidresources.repository.LeadsRepository;

@Service("LeadsValidator")
public class LeadsValidator {
	
	@Autowired
	private LeadsRepository leadsRepository;
	
	public void validateLeadsSaveRequest(SaveOrUpdateLeadRequest request) throws Exception{
		
		if(request == null || request.getLead()==null) {
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
		}
		
		if(StringUtils.isEmpty(request.getLead().getState()) || IndianStates.isValidState(request.getLead().getState()) == false) {
			throw new ValidationException(ApiErrorEnum.INVALID_STATE);
		}
		
		if(StringUtils.isEmpty(request.getLead().getType())) {
			throw new ValidationException(ApiErrorEnum.INVALID_TYPE);
		}
		
		if(StringUtils.isEmpty(request.getLead().getName())) {
			throw new ValidationException(ApiErrorEnum.INVALID_NAME);
		}
		
		if(request.getLead().getContactInformation()==null 
				|| CollectionUtils.isEmpty(request.getLead().getContactInformation().getPhoneNumber())) {
			throw new ValidationException(ApiErrorEnum.NO_CONTACT);
		}
		
	}
	
	public void validateLeadsUpdateRequest(SaveOrUpdateLeadRequest request, String leadUuid) throws Exception{
		 
		if(request == null || request.getLead()==null) {	
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
		}
		
		if(StringUtils.isEmpty(leadUuid)) {
			throw new ValidationException(ApiErrorEnum.INVALID_UUID);
		}
		
		Lead lead = leadsRepository.get(leadUuid).get();
		
		if(lead == null) {
			throw new ValidationException(ApiErrorEnum.NO_LEAD_CORRESPONDING_TO_UUID);
		}
		
		
		if(StringUtils.isNotEmpty(request.getLead().getState()) && IndianStates.isValidState(request.getLead().getState()) == false) {
			throw new ValidationException(ApiErrorEnum.INVALID_STATE);
		}
		
		
		if(request.getLead().getContactInformation()==null 
				|| CollectionUtils.isEmpty(request.getLead().getContactInformation().getPhoneNumber())) {
			throw new ValidationException(ApiErrorEnum.NO_CONTACT);
		}
		
	}
	
	public void validateLeadsFetchRequest(String leadUuid) throws Exception{
		
		if(StringUtils.isEmpty(leadUuid)) {
			throw new ValidationException(ApiErrorEnum.EMPTY_UUID);
		}
		
		Lead lead = leadsRepository.get(leadUuid).get();
		
		if(lead == null) {
			throw new ValidationException(ApiErrorEnum.NO_LEAD_CORRESPONDING_TO_UUID);
		}
		
	}
	
	public void validateLeadsListFetchRequest(FetchLeadsRequest request) throws Exception{
		
		if(request == null) {
			throw new ValidationException(ApiErrorEnum.EMPTY_UUID);
		}
		
	}
	
	

}
