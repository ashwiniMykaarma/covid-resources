package covidresources.model.documents;

import java.util.List;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class ContactInformation {
	
	List<String> phoneNumber;
	List<String> emailAddress;
	String address;
	Double latitude;
	Double longitude;
	@DocumentId
	String ID;
}
