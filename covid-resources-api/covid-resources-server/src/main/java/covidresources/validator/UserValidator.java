package covidresources.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import covidresources.enums.ApiErrorEnum;
import covidresources.exception.ValidationException;
import covidresources.model.documents.User;
import covidresources.model.request.SaveOrUpdateUserRequest;
import covidresources.repository.UserRepository;

@Service("UserValidator")
public class UserValidator {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VerificationValidator verificationValidator;
	
	public void validateUserSaveRequest(SaveOrUpdateUserRequest request) throws Exception{
		
		if(request == null || request.getUser()==null) {
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
		}
		
		if(StringUtils.isEmpty(request.getUser().getName())) {
			throw new ValidationException(ApiErrorEnum.INVALID_USER_NAME);
		}
		
		if(request.getUser().getContactInformation() == null || CollectionUtils.isEmpty(request.getUser().getContactInformation().getEmailAddress())) {
			throw new ValidationException(ApiErrorEnum.INVALID_USER_EMAIL);
		}
	}
	
	public void validateUserFetchRequest(String userUUID) throws Exception{
		
		if(StringUtils.isEmpty(userUUID)) {
			throw new ValidationException(ApiErrorEnum.INVALID_UUID);
		}
		
		User user = userRepository.get(userUUID).get();
		
		if(user == null) {
			throw new ValidationException(ApiErrorEnum.NO_USER_CORRESPONDING_TO_UUID);
		}
	}
	
	public void validateUserFetchByEmailRequest(String emailAddress) throws Exception{
		
		if(StringUtils.isEmpty(emailAddress)) {
			throw new ValidationException(ApiErrorEnum.INVALID_USER_EMAIL);
		}
		
		//get user by email.
		
//		User user = userRepository.get(userUUID).get();
//		
//		if(user == null) {
//			throw new ValidationException(ApiErrorEnum.NO_USER_CORRESPONDING_TO_UUID);
//		}
	}
	
	

}
