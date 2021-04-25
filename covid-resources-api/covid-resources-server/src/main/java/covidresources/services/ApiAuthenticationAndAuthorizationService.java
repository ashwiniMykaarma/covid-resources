package covidresources.services;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ApiAuthenticationAndAuthorizationService {
	
	public Boolean checkForAuthenticationAndAuthorization(HttpServletRequest request, Annotation[] annotations) throws Exception {


		String authString = request.getHeader("Authorization");

//		if (authString == null) {
//			ApiError error = calendarUtil.createErrorObject(
//					ApiErrorEnum.CREDENTIALS_ARE_NULL.name(), 
//					ApiErrorEnum.CREDENTIALS_ARE_NULL.getValue());
//
//			throw new UnauthorizedException(error);
//		}
//
//		String[] authParts = authString.split("\\s+");
//		String authInfo = authParts[1];
//		byte[] bytes;
//		try {
//			bytes = java.util.Base64.getDecoder().decode(authInfo);
//		} catch (Exception e) {
//			log.error("Exception caught while decoding credentials: ", e);
//			ApiError error = calendarUtil.createErrorObject(
//					ApiErrorEnum.INTERNAL_SERVER_ERROR.name(), 
//					ApiErrorEnum.INTERNAL_SERVER_ERROR.getValue());
//
//			throw new UnauthorizedException(error);
//		}
//		String decodedAuth = new String(bytes);
//
//		final String[] values = decodedAuth.split(":", 2);
//
//		ApiClient apiClient = apiClientJPARepository.findFirstByUserName(values[0]);
//		if (apiClient == null) {
//			ApiError error = calendarUtil.createErrorObject(
//					ApiErrorEnum.WRONG_CREDENTIAL.name(), 
//					ApiErrorEnum.WRONG_CREDENTIAL.getValue());
//
//			throw new UnauthorizedException(error);
//		}
//
//		if (!apiClient.getIsValid()) {
//			ApiError error = calendarUtil.createErrorObject(
//					ApiErrorEnum.ACCESS_FORBIDDEN_INVALID_PARTNER.name(), 
//					ApiErrorEnum.ACCESS_FORBIDDEN_INVALID_PARTNER.getValue());
//
//			throw new UnauthorizedException(error);
//		}
//
//		if (!apiClient.getPassword().equalsIgnoreCase(values[1])) {
//			ApiError error = calendarUtil.createErrorObject(
//					ApiErrorEnum.WRONG_CREDENTIAL.name(), 
//					ApiErrorEnum.WRONG_CREDENTIAL.getValue());
//
//			throw new UnauthorizedException(error);
//		}
//
//		log.info("Authentic client={}",values[0]);
//		Scope apiScope = null;
//		if (annotations != null && annotations.length > 0) {
//			for(Annotation annotation: annotations) {
//				if(annotation instanceof Authorize) {
//					apiScope = ((Authorize)annotation).apiScope();
//				}
//			}
//		}
//		if(apiScope != null) {
//			return checkScopeLevelAuthorization(request, annotations, apiClient, apiScope);
//		}
		return true;
	}
	

}
