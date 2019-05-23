package asw.sentenceservice.word.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.logging.Logger; 

@Service
public class WordService {

	@Value("${words}") 
	/* le parole di questo tipo */ 
	private String words;
	
	public String getWord() {
		/* restituisce una parola a caso tra le parole di questo tipo */ 
		String[] wordArray = words.split(",");
		int i = (int) (Math.round(Math.random()*(wordArray.length-1)));
		String word = wordArray[i];
		return word; 
	}
}
