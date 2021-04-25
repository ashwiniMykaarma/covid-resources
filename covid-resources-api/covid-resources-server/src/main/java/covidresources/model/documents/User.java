package covidresources.model.documents;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class User {
	
	String name;
	ContactInformation contactInformation;
	Boolean hasAuthorityToVerify;
	
	@DocumentId
	String UUID;

}
