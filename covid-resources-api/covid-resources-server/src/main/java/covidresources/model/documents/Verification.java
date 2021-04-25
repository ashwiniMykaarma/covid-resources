package covidresources.model.documents;

import java.util.Date;

import covidresources.model.DocumentId;
import lombok.Data;

@Data
public class Verification {
	
	String leadUUID;
	String userUUID;
	Boolean isAvailable;
	Date insertTS;
	
	@DocumentId
	String UUID;

}
