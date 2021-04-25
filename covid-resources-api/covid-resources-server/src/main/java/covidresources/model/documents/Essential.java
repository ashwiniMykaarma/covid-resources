package covidresources.model.documents;

import java.util.Date;

import lombok.Data;

@Data
public class Essential {
	
	String type;
	ContactInformation contactInformation;
	String description;
	String name;
	String UUID;
}
