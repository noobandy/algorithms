package ws;
import java.util.Map;
import java.util.HashMap;
import javax.jws.WebService;

@WebService(endpointInterface = "ws.IAlexa") 
public class Alexa implements IAlexa {
	Map<String, AlexaQueryResult> cache = new HashMap<String, AlexaQueryResult>();

	public AlexaQueryResult query(String siteUrl) {
		AlexaQueryResult result = cache.get(siteUrl);
		if(result == null) {
			System.out.format("contactig remote server for site : %s%n", siteUrl);
			AlexaQuery query = new AlexaQuery(siteUrl);
			result = query.result();
			cache.put(siteUrl, result);	
		}
		
		return result; 
	}
} 