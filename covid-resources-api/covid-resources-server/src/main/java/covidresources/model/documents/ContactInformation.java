package covidresources.model.documents;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class ContactInformation {
	
	String phoneNumber;
	String emailAddress;
	String address;
	Double latitude;
	Double longitude;
	@DocumentId
	String ID;
}
