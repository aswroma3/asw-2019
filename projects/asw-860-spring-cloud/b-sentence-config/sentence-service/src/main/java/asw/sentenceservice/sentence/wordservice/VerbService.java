package asw.sentenceservice.sentence.wordservice;

import asw.sentenceservice.sentence.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@Service 
public class VerbService implements WordService {

	private final Logger logger = Logger.getLogger(VerbService.class.toString()); 

	@Value("${word.verb.uri}") 
	private String verbUri;

	@Autowired 
	private WordClient wordClient;
	
	public String getWord() {
		return wordClient.getWord(verbUri); 
	}
	
}



