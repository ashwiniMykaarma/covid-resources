package covidresources.mapper;

import org.mapstruct.Mapper;

import covidresources.model.documents.ContactInformation;
import covidresources.model.documents.Essential;
import covidresources.model.documents.Lead;
import covidresources.model.documents.User;
import covidresources.model.documents.Verification;
import covidresources.model.dto.ContactInformationDTO;
import covidresources.model.dto.EssentialDTO;
import covidresources.model.dto.LeadDTO;
import covidresources.model.dto.UserDTO;
import covidresources.model.dto.VerificationDTO;

@Mapper(componentModel = "spring")
public abstract class DocumentMapper {
	
	public abstract UserDTO mapFSDBUsertoDTO(User user);
	
	public abstract User mapDTOtoFSDBUser(UserDTO userDTO);
	
	public abstract LeadDTO mapFSDBLeadtoDTO(Lead lead);
	
	public abstract Lead mapDTOtoFSDBLead(LeadDTO leadDTO);
	
	public abstract ContactInformationDTO mapFSDBContactInformationtoDTO(ContactInformation contactInformation);
	
	public abstract ContactInformation mapDTOtoFSDBContactInformation(ContactInformationDTO contactInformationDTO);
	
	public abstract EssentialDTO mapFSDBEssentialtoDTO(Essential essential);
	
	public abstract Essential mapDTOtoFSDBEssential(EssentialDTO essentialDTO);
	
	public abstract VerificationDTO mapFSDBVerificationtoDTO(Verification verification);
	
	public abstract Verification mapDTOtoFSDBVerification(VerificationDTO verificationDTO);

}
