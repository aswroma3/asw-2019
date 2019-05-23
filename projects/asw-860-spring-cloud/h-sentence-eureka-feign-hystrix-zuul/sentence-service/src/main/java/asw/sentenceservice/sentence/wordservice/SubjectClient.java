package asw.sentenceservice.sentence.wordservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("subject")
public interface SubjectClient {

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getWord(); 

}
