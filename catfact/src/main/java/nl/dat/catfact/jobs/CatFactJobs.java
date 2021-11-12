package nl.dat.catfact.jobs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import nl.dat.catfact.model.CatFactModel;
import nl.dat.catfact.repository.CatFactRepository;

/**
 * CatFactJobs is used to Schedule a CatFactJob for every 5 minutes requesting
 * the API (https://catfact.ninja/fact)
 * 
 * @author Nisha
 *
 */
@Component
public class CatFactJobs {

	@Autowired
	CatFactRepository catFactRepository;

	/**
	 * crawl is used to Schedule a CatFactJob for every 5 minutes requesting
	 * the API (https://catfact.ninja/fact)
	 * 
	 * @author Nisha
	 *
	 */
	@Scheduled(cron = "0 */5 * * * *")
	public void crawl() throws JsonMappingException, JsonProcessingException {
		CatFactModel catFactModel = new CatFactModel();
		final String uri = "https://catfact.ninja/fact";
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		CatFactModel catFact = objectMapper.readValue(result, CatFactModel.class);
		catFactModel.setCatFacts(catFact.getCatFacts());
		catFactRepository.save(new CatFactModel(catFactModel.getId(), catFactModel.getCatFacts()));

	}
}
