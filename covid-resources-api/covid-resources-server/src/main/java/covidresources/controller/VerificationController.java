package covidresources.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covidresources.enums.LogEnums;
import covidresources.enums.MDCConstants;
import covidresources.enums.RestURIConstants;
import covidresources.model.request.SaveVerificationRequest;
import covidresources.model.response.Response;
import covidresources.services.Utility;
import covidresources.services.VerificationService;
import io.swagger.annotations.Api;

@RestController("VerificationController")
@RequestMapping("/verification")
@Api(tags = "Verification Controller")
public class VerificationController {
	
	@Autowired
	VerificationService verificationService;
	
	@PutMapping(produces = RestURIConstants.APPLICATION_JSON)
	public Response saveVerification(
			@RequestBody SaveVerificationRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			MDC.put(LogEnums.LogEntityName.endpoint.name(), MDCConstants.SAVE_LEAD);
			MDC.put(LogEnums.LogEntityName.message_uuid.name(), Utility.getRandomUUID());
			
			return verificationService.saveVerification(request);
		} finally {
			MDC.clear();
		}
	}

}
