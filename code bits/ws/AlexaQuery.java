package ws;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;

public class AlexaQuery {
	private static final String ALEXA_API_END_POINT = "http://data.alexa.com/data?cli=10&url=";
	private String url;
	private String requestURL;

	public AlexaQuery(String url) {
		this.url = url;
		StringBuilder sb = new StringBuilder();
		sb.append(ALEXA_API_END_POINT);
		sb.append(this.url);
		requestURL = sb.toString();
	}

	public AlexaQueryResult result() {
		try {
			URL url = new URL(requestURL);
			InputStream is = url.openStream();
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = documentBuilder.parse(is);

			NamedNodeMap reach = document.getElementsByTagName("REACH").item(0).getAttributes();
			NamedNodeMap rank = document.getElementsByTagName("RANK").item(0).getAttributes();
			NamedNodeMap country = document.getElementsByTagName("COUNTRY").item(0).getAttributes();

			int globalRank = Integer.parseInt(reach.getNamedItem("RANK").getTextContent());
			int localRank = Integer.parseInt(country.getNamedItem("RANK").getTextContent());
			String rankChange = rank.getNamedItem("DELTA").getTextContent();
			String countryName = country.getNamedItem("NAME").getTextContent();
			
			return new AlexaQueryResult(this.url, globalRank, localRank, rankChange, countryName);

			/*File resultFile = new File("result.xml");
			if(!resultFile.exists()) {
				resultFile.createNewFile();
			}
			OutputStream os = new FileOutputStream(resultFile);

			byte[] buf = new byte[1024 * 1024];
			int readBytes = -1;

			while((readBytes = is.read(buf)) > 0) {
				os.write(buf, 0, readBytes);				}
				is.close();
				os.close();*/

			} catch(Exception e) {
				throw new RuntimeException(e);
			}

	}
}