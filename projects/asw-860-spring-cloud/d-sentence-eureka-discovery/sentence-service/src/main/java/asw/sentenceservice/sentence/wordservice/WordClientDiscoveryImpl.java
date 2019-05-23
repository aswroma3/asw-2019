package asw.sentenceservice.sentence.wordservice;

import java.net.URI;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.client.RestTemplate;

@Service 
public class WordClientDiscoveryImpl implements WordClient {

	@Autowired 
	private DiscoveryClient discoveryClient;

	public String getWord(String service) {
		List<ServiceInstance> list = discoveryClient.getInstances(service);
		if (list!=null && list.size()>0) {
			URI uri = list.get(0).getUri();
			if (uri!=null) {
				return new RestTemplate().getForObject(uri,String.class);
			}
		}
		return null;
	}	
	
}
