package covidresources.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import covidresources.enums.CovidResourcesAPILogCodes;
import covidresources.exception.ValidationException;
import covidresources.mapper.DocumentMapper;
import covidresources.model.documents.Lead;
import covidresources.model.documents.Verification;
import covidresources.model.request.SaveVerificationRequest;
import covidresources.model.response.Response;
import covidresources.repository.LeadsRepository;
import covidresources.repository.UserRepository;
import covidresources.repository.VerificationRepository;
import covidresources.validator.VerificationValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("VerificationService")
public class VerificationService {
	
	@Autowired
	VerificationRepository verificationRepository;
	
	@Autowired
	LeadsRepository leadsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VerificationValidator verificationValidator;
	
	@Autowired
	DocumentMapper documentMapper;
	
	public Response saveVerification(SaveVerificationRequest request) throws Exception {
		Response response = new Response();
		log.info("saving verification for request={}", Utility.toString(request));
		
		try {
			verificationValidator.validateVerificationSaveRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for saving verification request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		
		if(request.getVerification().getIsAvailable() == null) {
			request.getVerification().setIsAvailable(true);
		}
		
		Lead lead = leadsRepository.get(request.getVerification().getLeadUUID()).get();
		
		lead.setIsAvailable(request.getVerification().getIsAvailable());
		leadsRepository.save(lead);
		
		
		Verification verification = documentMapper.mapDTOtoFSDBVerification(request.getVerification());
		
		verificationRepository.save(verification);
		
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

}
