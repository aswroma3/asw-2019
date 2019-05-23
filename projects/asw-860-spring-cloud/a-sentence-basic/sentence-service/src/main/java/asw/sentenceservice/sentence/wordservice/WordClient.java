package asw.sentenceservice.sentence.wordservice;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service 
public class WordClient {

	public String getWord(String wordUri) {
		return new RestTemplate().getForObject(wordUri, String.class);
	}	

}
