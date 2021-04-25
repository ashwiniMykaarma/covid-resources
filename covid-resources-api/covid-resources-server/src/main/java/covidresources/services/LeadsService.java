package covidresources.services;

import covidresources.LeadsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import covidresources.enums.CovidResourcesAPILogCodes;
import covidresources.exception.ValidationException;
import covidresources.mapper.DocumentMapper;
import covidresources.model.documents.Lead;
import covidresources.model.request.SaveLeadRequest;
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
	
	public SaveLeadResponse saveLeads(SaveLeadRequest request) throws Exception {
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
		//String documentID = leadsRepository.save(lead);
		System.out.println(leadsRepository.filterAndRetreive());
		return response;
	}

}
