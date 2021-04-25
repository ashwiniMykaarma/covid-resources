package covidresources.model.documents;

import lombok.Data;

@Data
public class User {
	
	String name;
	ContactInformation contactInformation;
	String UUID;

}
