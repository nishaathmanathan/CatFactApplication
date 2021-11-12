package nl.dat.catfact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.dat.catfact.model.CatFactModel;
import nl.dat.catfact.repository.CatFactRepository;

/**
 * CatFactController is used to access the end point in the rest api
 * 
 * @author Nisha
 *
 */
@RestController
public class CatFactController {

	@Autowired
	CatFactRepository catFactRepository;

	/**
	 * getFacts method is used to returning facts from the given URL
	 * 
	 * @return facts
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@GetMapping("/getFacts")
	public ResponseEntity<String> getCatFacts() throws JsonMappingException, JsonProcessingException {
		final String uri = "https://catfact.ninja/fact";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		CatFactModel catFact = objectMapper.readValue(result, CatFactModel.class);
		return new ResponseEntity<>(catFact.getCatFacts().toString(), HttpStatus.OK);

	}
}
