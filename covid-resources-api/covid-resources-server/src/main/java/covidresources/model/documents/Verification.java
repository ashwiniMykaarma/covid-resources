package covidresources.model.documents;

import java.util.Date;

import lombok.Data;

@Data
public class Verification {
	
	String essentialUUID;
	String userUUID;
	Date insertTS;

}
