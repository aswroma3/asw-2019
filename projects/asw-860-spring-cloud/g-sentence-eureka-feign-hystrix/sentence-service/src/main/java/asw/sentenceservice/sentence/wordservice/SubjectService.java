package asw.sentenceservice.sentence.wordservice;

import asw.sentenceservice.sentence.domain.WordService;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.logging.Logger; 

@Service 
public class SubjectService implements WordService {

	private final Logger logger = Logger.getLogger(SubjectService.class.toString()); 

	@Autowired 
	private SubjectClient subjectClient;

	@HystrixCommand(fallbackMethod="getFallbackWord")
	public String getWord() {
		return subjectClient.getWord(); 
	} 
	
	public String getFallbackWord() {
		logger.info("subject.getWord(): using fallback word: Someone");
		return "Someone"; 
	}
	
}
