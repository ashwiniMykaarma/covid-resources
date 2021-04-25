package covidresources.services;

import java.util.ArrayList;
import java.util.List;

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
import covidresources.repository.LeadsRepository;
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
		
		if(request.getLead().getIsAvailable() == null) {
			request.getLead().setIsAvailable(true);
		}
		
		Lead lead = documentMapper.mapDTOtoFSDBLead(request.getLead());
		
		String documentID = leadsRepository.save(lead);
		
		response.setStatusCode(HttpStatus.OK.value());
		response.setLeadUuid(documentID);
		return response;
	}
	
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
		
		Lead lead = leadsRepository.get(leadUuid).get();
		
		if(StringUtils.isEmpty(request.getLead().getDescription())) {
			lead.setDescription(request.getLead().getDescription());
		}
		
		if(StringUtils.isEmpty(request.getLead().getName())) {
			lead.setName(request.getLead().getName());
		}
		
		if(StringUtils.isEmpty(request.getLead().getState())) {
			lead.setState(request.getLead().getState());
		}
		
		if(StringUtils.isEmpty(request.getLead().getType())) {
			lead.setType(request.getLead().getType());
		}
		
		if(request.getLead().getContactInformation() != null) {
			
			if(CollectionUtils.isEmpty(request.getLead().getContactInformation().getPhoneNumber()) == false) {
				lead.getContactInformation().setPhoneNumber(request.getLead().getContactInformation().getPhoneNumber());
			}
			
			if(CollectionUtils.isEmpty(request.getLead().getContactInformation().getEmailAddress()) == false) {
				lead.getContactInformation().setEmailAddress(request.getLead().getContactInformation().getEmailAddress());
			}
			
			if(StringUtils.isEmpty(request.getLead().getContactInformation().getAddress())) {
				lead.getContactInformation().setAddress(request.getLead().getContactInformation().getAddress());
			}
			
			if(request.getLead().getContactInformation().getLatitude() != null) {
				lead.getContactInformation().setLatitude(request.getLead().getContactInformation().getLatitude());
			}
			
			if(request.getLead().getContactInformation().getLongitude() != null) {
				lead.getContactInformation().setLongitude(request.getLead().getContactInformation().getLongitude());
			}
		}
		
		String documentID = leadsRepository.save(lead);
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
		
		response.setStatusCode(HttpStatus.OK.value());
		response.setLead(leadDTO);
		return response;
	}
	
	public FetchLeadListResponse fetchLeadList(FetchLeadsRequest request) throws Exception {
		FetchLeadListResponse response = new FetchLeadListResponse();
		log.info("fetching leads for request={}", Utility.toString(request));
		
		try {
			leadsValidator.validateLeadsListFetchRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for fetching lead list for request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		List<Lead> leadsList = leadsRepository.filterLeadsForStatesAndCities(request.getStates(), request.getCities());
		log.info("list from DB={}", Utility.toString(leadsList));
		if(CollectionUtils.isEmpty(leadsList)) {
			response.setStatusCode(HttpStatus.NO_CONTENT.value());
		}else {
			List<LeadDTO> leadDTOList = new ArrayList<LeadDTO>();
			for(Lead lead: leadsList) {
				LeadDTO leadDTO = documentMapper.mapFSDBLeadtoDTO(lead);
				leadDTOList.add(leadDTO);
			}
			response.setLead(leadDTOList);
			response.setStatusCode(HttpStatus.OK.value());
		}
		return response;
	}

}
