package asw.sentenceservice.sentence.wordservice;

import asw.sentenceservice.sentence.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.logging.Logger; 

@Service 
public class VerbService implements WordService {

	private final Logger logger = Logger.getLogger(VerbService.class.toString()); 

	@Autowired 
	private VerbClient verbClient;

	@HystrixCommand(fallbackMethod="getFallbackWord")
	public String getWord() {
		return verbClient.getWord(); 
	}
	
	public String getFallbackWord() {
		logger.info("verb.getWord(): using fallback word: does");
		return "does"; 
	}
	
}
