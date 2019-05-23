package asw.sentenceservice.sentence.wordservice;

import asw.sentenceservice.sentence.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@Service 
public class ObjectService implements WordService {

	private final Logger logger = Logger.getLogger(ObjectService.class.toString()); 

	@Value("${word.object.uri}") 
	private String objectUri;

	@Autowired 
	private WordClient wordClient;
	
	public String getWord() {
		return wordClient.getWord(objectUri); 
	}
	
}



