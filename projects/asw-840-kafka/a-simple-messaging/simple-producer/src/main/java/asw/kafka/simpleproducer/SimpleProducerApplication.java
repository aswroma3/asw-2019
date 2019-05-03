package asw.kafka.simpleproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* esecuzione: gradle simple-producer:bootRun */
/* per usare un altro gruppo: ASW_KAFKA_GROUPID=pluto gradle simple-producer:bootRun */
/* per scrivere su un altro canale: ASW_KAFKA_CHANNEL_OUT=beta gradle simple-producer:bootRun */

@SpringBootApplication
public class SimpleProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleProducerApplication.class, args);
	}

}

