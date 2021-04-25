package covidresources.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import covidresources.enums.CovidResourcesAPILogCodes;
import covidresources.exception.ValidationException;
import covidresources.mapper.DocumentMapper;
import covidresources.model.documents.Lead;
import covidresources.model.documents.User;
import covidresources.model.documents.Verification;
import covidresources.model.dto.UserDTO;
import covidresources.model.request.SaveOrUpdateUserRequest;
import covidresources.model.request.SaveVerificationRequest;
import covidresources.model.response.FetchUserResponse;
import covidresources.model.response.Response;
import covidresources.model.response.SaveUserResponse;
import covidresources.repository.LeadsRepository;
import covidresources.repository.UserRepository;
import covidresources.repository.VerificationRepository;
import covidresources.validator.UserValidator;
import covidresources.validator.VerificationValidator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("UserService")
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserValidator userValidator;
	
	@Autowired
	DocumentMapper documentMapper;
	
	public SaveUserResponse saveUser(SaveOrUpdateUserRequest request) throws Exception {
		SaveUserResponse response = new SaveUserResponse();
		log.info("saving user for request={}", Utility.toString(request));
		
		try {
			userValidator.validateUserSaveRequest(request);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for saving user request={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					Utility.toString(request), validationException.getApiError().getCode());
			throw validationException;
		}
		
		if(request.getUser().getHasAuthorityToVerify()== null) {
			request.getUser().setHasAuthorityToVerify(true);
		}
		
		
		User user = documentMapper.mapDTOtoFSDBUser(request.getUser());
		
		String documentID = userRepository.save(user);
		
		response.setStatusCode(HttpStatus.OK.value());
		response.setUserUuid(documentID);
		return response;
	}
	
	public FetchUserResponse fetchUser(String userUuid) throws Exception {
		FetchUserResponse response = new FetchUserResponse();
		log.info("fetching user for uuid={}", userUuid);
		try {
			userValidator.validateUserFetchRequest(userUuid);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for saving user userUuid={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					userUuid, validationException.getApiError().getCode());
			throw validationException;
		}
		
		User user = userRepository.get(userUuid).get();
		
		UserDTO userDTO = documentMapper.mapFSDBUsertoDTO(user);
		response.setUser(userDTO);
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}
	
	public FetchUserResponse fetchUserByEmail(String emailAddress) throws Exception {
		FetchUserResponse response = new FetchUserResponse();
		log.info("fetching user for emailAddress={}", emailAddress);
		try {
			userValidator.validateUserFetchByEmailRequest(emailAddress);
		}catch(ValidationException validationException) {
			log.warn(" {} Validation failed for saving user emailAddress={} error_code={} ", 
					CovidResourcesAPILogCodes.COVID_RESOURCES_API_ERROR_CODE.getLogMessage(),
					emailAddress, validationException.getApiError().getCode());
			throw validationException;
		}
		User user = userRepository.filterDocumentsForValueInListObject("contactInformation.emailAddress",emailAddress).get();
 		UserDTO userDTO = documentMapper.mapFSDBUsertoDTO(user);
		response.setUser(userDTO);
		response.setStatusCode(HttpStatus.OK.value());
		return response;
	}

}
