package covidresources.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import covidresources.enums.CovidResourcesAPILogCodes;
import covidresources.exception.ValidationException;
import covidresources.mapper.DocumentMapper;
import covidresources.model.documents.Lead;
import covidresources.model.request.FetchLeadsRequest;
import covidresources.model.request.SaveOrUpdateLeadRequest;
import covidresources.model.response.FetchLeadListResponse;
import covidresources.model.response.FetchLeadResponse;
import covidresources.model.response.SaveLeadResponse;
import covidresources.validator.LeadsValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("LeadsService")
public class LeadsService {
	
	@Autowired
	LeadsValidator leadsValidator;
	
	@Autowired
	DocumentMapper documentMapper;
	
	public SaveLeadResponse saveLead(SaveOrUpdateLeadRequest request) throws Exception {
		SaveLeadResponse response = new SaveLeadResponse();
		log.info("saving leads for request={}", Utility.toString(request));
		
		try {
			leadsValidator.validateLeadsSaveRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for saving leads request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		
		log.info("dto object={}", Utility.toString(request.getLead()));
		
		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
		
		log.info("mapped object={}", Utility.toString(lead));
		
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}
	
	public SaveLeadResponse updateLead(SaveOrUpdateLeadRequest request) throws Exception {
		SaveLeadResponse response = new SaveLeadResponse();
		log.info("updating leads for request={}", Utility.toString(request));
		
		try {
			leadsValidator.validateLeadsSaveRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for updating leads request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		
		log.info("dto object={}", Utility.toString(request.getLead()));
		
		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
		
		log.info("mapped object={}", Utility.toString(lead));
		
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}
	
	public FetchLeadResponse fetchLead(String leadUuid) throws Exception {
		FetchLeadResponse response = new FetchLeadResponse();
		log.info("updating leads for lead_uuid={}", leadUuid);
		
		try {
			leadsValidator.validateLeadsFetchRequest(leadUuid);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for fetching lead for uuid={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					leadUuid, validationException.getApiError().getCode());
			throw validationException;
		}
		
//		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
//		
//		log.info("mapped object={}", Utility.toString(lead));
		
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}
	
	public FetchLeadListResponse fetchLeadList(FetchLeadsRequest request) throws Exception {
		FetchLeadListResponse response = new FetchLeadListResponse();
		log.info("updating leads for request={}", Utility.toString(request));
		
		try {
			leadsValidator.validateLeadsListFetchRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for fetching lead list for request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		
//		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
//		
//		log.info("mapped object={}", Utility.toString(lead));
		
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

}
