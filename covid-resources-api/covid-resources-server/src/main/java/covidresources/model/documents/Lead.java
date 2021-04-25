package covidresources.model.documents;

import lombok.Data;

@Data
public class Lead {
	
	String state;
	String type;
	ContactInformation contactInformation;
	String description;
	String name;
	String UUID;
	
}
