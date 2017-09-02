import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.net.*;

public class RestJava {

	private String basePath;
	private Map<String, String> headers;
	private String encoding = "utf8";

	public RestJava(String basePath) {
		this(basePath, new HashMap<String, String>());
	}

	public RestJava(String basePath, Map<String, String> headers) {
		this.basePath = basePath;
		this.headers = headers;
	}



	public String get(String path, Map<String, String> query) throws Exception {
		StringBuilder uriBuilder = new StringBuilder();
		uriBuilder.append(basePath).append(path);
		uriBuilder.append('?');
		
		boolean first = true;

		for(Entry<String, String> entry : query.entrySet()) {
			if(!first) {
				uriBuilder.append('&');
			} else {
				first = false;
			}

			uriBuilder.append(URLEncoder.encode(entry.getKey(), encoding))
			.append('=').append(URLEncoder.encode(entry.getValue(), encoding));
		}

		URI uri = new URI(uriBuilder.toString());

		URL url = uri.toURL();

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		//connection.setDataOuput(true);

		connection.setRequestMethod("GET");

		for(Entry<String, String> entry : headers.entrySet()) {
			connection.addRequestProperty(entry.getKey(), entry.getValue());
		}

		System.out.println(url.toString());

		connection.connect();

		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder responseBuilder = new StringBuilder();

		String line = null;

		while((line = br.readLine()) != null) {
			responseBuilder.append(line);
		}

		br.close();

		return responseBuilder.toString();
	}

	public static void main(String[] args) throws Exception {

		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");

		RestJava api = new RestJava("https://mahalabharthi.in/server/app1/v1/BaseServer/", headers);

		System.out.println(api.get("mastersData/DepartmentMaster/mr", new HashMap<String, String>()));

	}
}