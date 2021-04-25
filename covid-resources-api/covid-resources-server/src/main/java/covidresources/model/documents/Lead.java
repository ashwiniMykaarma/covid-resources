package covidresources.model.documents;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class Lead {	
	String state;
	String city;
	String type;
	ContactInformation contactInformation;
	String description;
	String name;
	Boolean isAvailable;
	
	@DocumentId
	String UUID;
	
}
