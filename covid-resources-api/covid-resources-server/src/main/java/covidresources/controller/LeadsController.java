package covidresources.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covidresources.enums.RestURIConstants;
import covidresources.model.request.SaveLeadRequest;
import covidresources.model.response.SaveLeadResponse;
import covidresources.services.LeadsService;
import io.swagger.annotations.Api;

@RestController("LeadsController")
@RequestMapping("/lead")
@Api(tags = "Leads Controller")
public class LeadsController {
	
	@Autowired
	LeadsService leadsService;
	
	@PutMapping(produces = RestURIConstants.APPLICATION_JSON)
	public SaveLeadResponse saveLeads(
			@RequestBody SaveLeadRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.saveLeads(request);
		} finally {
			MDC.clear();
		}
	}

}
