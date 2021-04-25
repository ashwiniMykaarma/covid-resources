package covidresources.services;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import covidresources.model.response.ApiError;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Utility {
	
	public static String getRandomUUID() {
		return DigestUtils.sha256Hex(UUID.randomUUID().toString());
	}
	
	public static String toString(Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(object);
		} catch (Exception e) {
			log.error("Error while parsing json to string", e);
			return "";
		}
	}
	
	public ApiError createErrorObject(String code, String description) {
		ApiError error = new ApiError();
		error.setCode(code);
		error.setDescription(description);
		return error;
	}

}
