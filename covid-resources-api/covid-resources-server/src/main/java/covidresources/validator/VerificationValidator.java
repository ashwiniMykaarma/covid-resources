package covidresources.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covidresources.enums.ApiErrorEnum;
import covidresources.exception.ValidationException;
import covidresources.model.documents.Lead;
import covidresources.model.documents.User;
import covidresources.model.request.SaveVerificationRequest;
import covidresources.repository.LeadsRepository;
import covidresources.repository.UserRepository;

@Service("VerificationValidator")
public class VerificationValidator {
	
	@Autowired
	LeadsRepository leadsRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public void validateVerificationSaveRequest(SaveVerificationRequest request) throws Exception{
		
		if(request == null || request.getVerification()==null) {
			throw new ValidationException(ApiErrorEnum.EMPTY_REQUEST);
		}
		
		if(StringUtils.isEmpty(request.getVerification().getLeadUUID())) {
			throw new ValidationException(ApiErrorEnum.INVALID_STATE);
		}
		
		Lead lead = leadsRepository.get(request.getVerification().getLeadUUID()).get();
		
		if(lead == null) {
			throw new ValidationException(ApiErrorEnum.NO_LEAD_CORRESPONDING_TO_UUID);
		}
		
		if(StringUtils.isEmpty(request.getVerification().getLeadUUID())) {
			throw new ValidationException(ApiErrorEnum.INVALID_STATE);
		}
		
		User user = userRepository.get(request.getVerification().getUserUUID()).get();
		
		if(user == null) {
			throw new ValidationException(ApiErrorEnum.NO_USER_CORRESPONDING_TO_UUID);
		}
		
		if(user.getHasAuthorityToVerify() != null && user.getHasAuthorityToVerify() == false) {
			throw new ValidationException(ApiErrorEnum.USER_IS_NOT_AUTHORISED_TO_VERIFY);
		}
	}
	
}
