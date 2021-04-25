package covidresources.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covidresources.enums.LogEnums;
import covidresources.enums.MDCConstants;
import covidresources.enums.RestURIConstants;
import covidresources.model.request.SaveOrUpdateUserRequest;
import covidresources.model.response.Response;
import covidresources.services.UserService;
import covidresources.services.Utility;
import io.swagger.annotations.Api;

@RestController("UserController")
@RequestMapping("/user")
@Api(tags = "User Controller")
public class UserController {

	@Autowired
	UserService userService;

	@PutMapping(produces = RestURIConstants.APPLICATION_JSON)
	public Response saveUser(
			@RequestBody SaveOrUpdateUserRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {

			MDC.put(LogEnums.LogEntityName.endpoint.name(), MDCConstants.SAVE_USER);
			MDC.put(LogEnums.LogEntityName.message_uuid.name(), Utility.getRandomUUID());

			return userService.saveUser(request);
		} finally {
			MDC.clear();
		}
	}

	@GetMapping(value= RestURIConstants.USER_UUID_URI,produces = RestURIConstants.APPLICATION_JSON)
	public Response fetchUser(
			@PathVariable(RestURIConstants.USER_UUID) String userUuid,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {

			MDC.put(LogEnums.LogEntityName.endpoint.name(), MDCConstants.FETCH_USER);
			MDC.put(LogEnums.LogEntityName.message_uuid.name(), Utility.getRandomUUID());

			return userService.fetchUser(userUuid);
		} finally {
			MDC.clear();
		}
	}
	
	@GetMapping(value= RestURIConstants.EMAIL + RestURIConstants.USER_EMAIL_URI,produces = RestURIConstants.APPLICATION_JSON)
	public Response fetchUserByEmail(
			@PathVariable(RestURIConstants.USER_EMAIL) String emailAddress,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {

			MDC.put(LogEnums.LogEntityName.endpoint.name(), MDCConstants.FETCH_USER);
			MDC.put(LogEnums.LogEntityName.message_uuid.name(), Utility.getRandomUUID());

			return userService.fetchUser(userUuid);
		} finally {
			MDC.clear();
		}
	}

}
