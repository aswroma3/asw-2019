package asw.sentenceservice.sentence.rest;

import asw.sentenceservice.sentence.domain.SentenceService; 

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger; 

@RestController
public class SentenceController {

	private final Logger logger = Logger.getLogger(SentenceController.class.toString()); 

	@Autowired 
	private SentenceService sentenceService;

	@RequestMapping("/sentence")
	public String getSentence() {
		String sentence = sentenceService.getSentence(); 
		logger.info("getSentence(): " + sentence);
		return sentence; 
	}
	
}
