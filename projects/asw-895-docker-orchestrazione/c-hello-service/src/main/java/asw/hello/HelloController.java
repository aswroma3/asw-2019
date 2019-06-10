package asw.hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.InetAddress;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Scanner; 

@RestController
public class HelloController {

    /* Restituisce Hello, world from this host! */
	@RequestMapping("/")
	public String hello() {
		return "Hello from " + getHostname() + "!"; 
	}
	
	String hostname = null; 

 	/* Calcola l'hostname di questo nodo */
	private String getHostname() {
		if (hostname==null) {
			hostname = ""; 
			try {
				Process p = Runtime.getRuntime().exec("hostname");
				Scanner scanner = new Scanner(p.getInputStream()); 
				if ( scanner.hasNext() ) {
					hostname = scanner.next(); 
				}
				p.destroy();
			} catch (Exception e) {}
		}
		return hostname;
	}

	/* Calcola l'hostname di questo nodo */
	private String getHostname_NON_FUNZIONA_CON_DOCKER() {
		String result = null; 
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String hostname = ip.getHostName();
			String ipAddress = ip.getHostAddress(); 
			result = hostname + " (" + ipAddress + ")"; 
        } catch (Exception e) {
            // e.printStackTrace();
        }
		return result; 
	}
	
}
