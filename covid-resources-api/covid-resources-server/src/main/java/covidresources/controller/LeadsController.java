package covidresources.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covidresources.enums.RestURIConstants;
import covidresources.model.request.SaveLeadsRequest;
import covidresources.model.response.SaveLeadsResponse;
import covidresources.services.LeadsService;
import io.swagger.annotations.Api;

@RestController("LeadsController")
@RequestMapping()
@Api(tags = "Leads Controller")
public class LeadsController {
	
	@Autowired
	LeadsService leadsService;
	
	@PutMapping(value = RestURIConstants.SAVE, produces = RestURIConstants.APPLICATION_JSON)
	public SaveLeadsResponse saveLeads(
			@RequestBody SaveLeadsRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.saveLeads(request);
		} finally {
			MDC.clear();
		}
	}

}
