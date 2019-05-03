package asw.kafka.simplefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/* esecuzione: gradle simple-filter:bootRun */
/* per usare un altro gruppo: ASW_KAFKA_GROUPID=pluto gradle simple-filter:bootRun */
/* per leggere da un altro canale: ASW_KAFKA_CHANNEL_IN=beta gradle simple-filter:bootRun */
/* per scrivere su un altro canale: ASW_KAFKA_CHANNEL_OUT=gamma gradle simple-filter:bootRun */

@SpringBootApplication
public class SimpleFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFilterApplication.class, args);
	}

}

