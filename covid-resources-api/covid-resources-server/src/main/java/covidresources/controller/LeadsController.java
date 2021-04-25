package covidresources.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import covidresources.enums.RestURIConstants;
import covidresources.model.request.FetchLeadsRequest;
import covidresources.model.request.SaveOrUpdateLeadRequest;
import covidresources.model.response.FetchLeadListResponse;
import covidresources.model.response.FetchLeadResponse;
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
			@RequestBody SaveOrUpdateLeadRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.saveLead(request);
		} finally {
			MDC.clear();
		}
	}
	
	@PatchMapping(value= RestURIConstants.LEAD_UUID_URI,produces = RestURIConstants.APPLICATION_JSON)
	public SaveLeadResponse updateLeads(
			@RequestBody SaveOrUpdateLeadRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.updateLead(request);
		} finally {
			MDC.clear();
		}
	}
	
	@GetMapping(value= RestURIConstants.LEAD_UUID_URI,produces = RestURIConstants.APPLICATION_JSON)
	public FetchLeadResponse fetchLead(
			@PathVariable(RestURIConstants.LEAD_UUID) String leadUuid,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.fetchLead(leadUuid);
		} finally {
			MDC.clear();
		}
	}
	
	@PostMapping(value= RestURIConstants.LIST,produces = RestURIConstants.APPLICATION_JSON)
	public FetchLeadListResponse fetchLeadList(
			@RequestBody FetchLeadsRequest request,
			@RequestHeader(RestURIConstants.AUTHORIZATION) String authToken
			) throws Exception {
		try {
			
			return leadsService.fetchLeadList(request);
		} finally {
			MDC.clear();
		}
	}

}
