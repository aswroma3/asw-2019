package asw.spring.show;

import asw.spring.show.config.ShowConfig; 

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Test;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ShowConfig.class)
public class HendrixTest {

	@Autowired
	private Artist hendrix; 
	
	@Test 
	public void hendrixTest() {
    	assertEquals( "I'm Jimi: Ta ta taa", hendrix.perform() );
	}

}
