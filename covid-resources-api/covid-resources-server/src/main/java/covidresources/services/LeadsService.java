package covidresources.services;

import org.springframework.stereotype.Service;

import covidresources.model.request.SaveLeadsRequest;
import covidresources.model.response.SaveLeadsResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("LeadsService")
public class LeadsService {
	
	public SaveLeadsResponse saveLeads(SaveLeadsRequest request) {
		log.info("saving leads");
		return null;
	}

}
