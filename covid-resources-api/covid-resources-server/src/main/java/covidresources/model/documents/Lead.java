package covidresources.model.documents;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class Lead {
	
	String state;
	Essential essential;
	@DocumentId
	String UUID;
	
}
