package covidresources.services;

import covidresources.LeadsRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import covidresources.enums.CovidResourcesAPILogCodes;
import covidresources.exception.ValidationException;
import covidresources.mapper.DocumentMapper;
import covidresources.model.documents.Lead;
import covidresources.model.dto.LeadDTO;
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

	@Autowired
	LeadsRepository leadsRepository;
	
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
		
		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
		
		String documentID = leadsRepository.save(lead);
		log.info("Saved lead with ID : "+documentID);
		response.setStatusCode(HttpStatus.OK.value());
		response.setLeadUuid(documentID);
		return response;
	}

	// update Lead if exist , else create new Lead
	public SaveLeadResponse updateLead(SaveOrUpdateLeadRequest request, String leadUuid) throws Exception {
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

		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
		String documentID = leadsRepository.update(lead,leadUuid);
		response.setStatusCode(HttpStatus.OK.value());
		response.setLeadUuid(documentID);
		return response;
	}
	
	public FetchLeadResponse fetchLead(String leadUuid) throws Exception {
		FetchLeadResponse response = new FetchLeadResponse();
		log.info("fetching lead for lead_uuid={}", leadUuid);
		
		try {
			leadsValidator.validateLeadsFetchRequest(leadUuid);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for fetching lead for uuid={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					leadUuid, validationException.getApiError().getCode());
			throw validationException;
		}
		
		log.info(Utility.toString(leadsRepository.get(leadUuid)));
		Lead lead = leadsRepository.get(leadUuid).get();
		LeadDTO leadDTO = documentMapper.mapFSDBLeadtoDTO(lead);
		log.info(leadDTO.getState());
		response.setStatusCode(HttpStatus.OK.value());
		response.setLead(leadDTO);
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
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

}
