package asw.kafka.simplefilter.domain;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Service 
public class SimpleFilterService {

    private Logger logger = Logger.getLogger(SimpleFilterService.class.toString());

	@Autowired
	private SimpleMessagePublisher simpleMessagePublisher;

    public void filter(String inMessage) {
		String outMessage = "*** " + inMessage + " ***"; 
		logger.info("FILTERING MESSAGE: " + inMessage + " TO: " + outMessage);
		simpleMessagePublisher.publish(outMessage); 
	}
	
}
