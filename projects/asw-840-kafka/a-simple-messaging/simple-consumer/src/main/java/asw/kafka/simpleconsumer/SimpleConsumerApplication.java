package asw.kafka.simpleconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* esecuzione: gradle simple-consumer:bootRun */
/* per usare un altro gruppo: ASW_KAFKA_GROUPID=pluto gradle simple-consumer:bootRun */
/* per leggere da un altro canale: ASW_KAFKA_CHANNEL_IN=beta gradle simple-consumer:bootRun */

@SpringBootApplication
public class SimpleConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleConsumerApplication.class, args);
	}

}

