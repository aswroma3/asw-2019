package asw.sentenceservice.word.rest;

import asw.sentenceservice.word.domain.WordService;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger; 

@RestController
public class WordController {

	@Autowired 
	private WordService wordService;

	private final Logger logger = Logger.getLogger(WordController.class.toString()); 

	@RequestMapping("/")
	public String getWord() {
		String word = wordService.getWord(); 
		logger.info("getWord(): " + word);
		return word; 
	}
}
