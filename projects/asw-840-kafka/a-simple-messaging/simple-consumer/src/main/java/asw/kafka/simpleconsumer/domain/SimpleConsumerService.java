package asw.kafka.simpleconsumer.domain;

import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service 
public class SimpleConsumerService {

    private Logger logger = Logger.getLogger(SimpleConsumerService.class.toString());

    public void onMessage(String message) {
		logger.info("RECEIVED MESSAGE: " + message);
	}
	
}
