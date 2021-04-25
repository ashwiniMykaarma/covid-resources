package covidresources.model.documents;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class Lead {	
	String state;
	String type;
	ContactInformation contactInformation;
	String description;
	String name;
	
	@DocumentId
	String UUID;
	
}
