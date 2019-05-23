package asw.sentenceservice.sentence.wordservice;

import java.net.URI;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.client.RestTemplate;

@Service 
public class WordClientRibbonImpl implements WordClient {

	@Autowired 
	private LoadBalancerClient loadBalancer;

	public String getWord(String service) {
		ServiceInstance instance = loadBalancer.choose(service);
		if (instance!=null) {
			URI uri = instance.getUri();
			if (uri!=null) {
				return new RestTemplate().getForObject(uri,String.class);
			}
		}
		return null;
	}	
	
}
