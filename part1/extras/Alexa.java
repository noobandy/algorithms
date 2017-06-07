import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
public class Alexa {
	
	private static final class AlexaQuery {
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
				File resultFile = new File("result.xml");
				if(!resultFile.exists()) {
					resultFile.createNewFile();
				}
				OutputStream os = new FileOutputStream(resultFile);

				byte[] buf = new byte[1024 * 1024];
				int readBytes = -1;

				while((readBytes = is.read(buf)) > 0) {
					os.write(buf, 0, readBytes);
				}
				is.close();
				os.close();

			} catch(Exception e) {
				System.out.println(e);
				System.exit(1);
			}
			return null;
		}
	}

	private static final class AlexaQueryResult {
		private String url;
		private int globalRank;
		private int localRank;
		private int rankChange;
		private String country;
	}

	public static void main(String[] args) {
		String siteUrl = args[0];
		if(siteUrl !=  null && !siteUrl.trim().isEmpty()) {
			AlexaQuery query = new AlexaQuery(siteUrl);
			AlexaQueryResult result = query.result();
		} else {
			System.out.println("site url missing");
			System.exit(1);
		}
	}
} 