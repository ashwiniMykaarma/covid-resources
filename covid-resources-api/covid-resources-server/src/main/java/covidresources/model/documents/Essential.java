package covidresources.model.documents;

import java.util.Date;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class Essential {
	
	String type;
	ContactInformation contactInformation;
	String description;
	String name;
	@DocumentId
	String UUID;
}
