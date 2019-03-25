package asw.spring.show;

import asw.spring.show.config.ShowConfig; 

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class HendrixTest {

	private Artist artist; 
	
	@Before 
	public void setupHendrix() {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ShowConfig.class); 
    	this.artist = (Artist) context.getBean("hendrix");
	}

	@Test 
	public void hendrixTest() {
    	assertEquals( "I'm Jimi: Ta ta taa", artist.perform() );
	}

}
