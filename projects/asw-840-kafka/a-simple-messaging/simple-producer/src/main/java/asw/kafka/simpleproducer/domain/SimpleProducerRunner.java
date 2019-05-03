package asw.kafka.simpleproducer.domain;

import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.logging.*;

@Component
public class SimpleProducerRunner implements CommandLineRunner {

	private static final Logger logger = Logger.getLogger(SimpleProducerRunner.class.toString());

	@Autowired
	private SimpleProducerService simpleProducerService;

	public void run(String[] args) throws InterruptedException {
		
		for (int i=0; i<10; i++) {
			String message = "Message #" + i; 
			// logger.info("Sending message: " + message); 
			simpleProducerService.publish(message); 
		}

	}
}
