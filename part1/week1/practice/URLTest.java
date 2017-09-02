import java.io.*;
import java.net.*;

public class URLTest {
	public static void main(String[] args) throws Exception {
		URI uri = new URI("https", "docs.oracle.com", "/javase/tutorial/networking/urls/urlInfo.html", "a=5&b=6", "id_a");

		URL url = uri.toURL();

		System.out.format("Protocol: %s%n", url.getProtocol());
		System.out.format("Authority: %s%n", url.getAuthority());
		System.out.format("Host: %s%n", url.getHost());
		System.out.format("Port: %s%n", url.getPort());
		System.out.format("Path: %s%n", url.getPath());
		System.out.format("File: %s%n", url.getFile());
		System.out.format("Query: %s%n", url.getQuery());
		System.out.format("Ref: %s%n", url.getRef());

		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		File outDir = new File("." + File.separator + "html");
		if(!outDir.exists()) {
			outDir.mkdirs();
		}

		File outFile = new File(outDir, url.getPath().substring(url.getPath().lastIndexOf("/")));
		
		if(!outFile.exists()) {
			outFile.createNewFile();
		}

		URLConnection connection = url.openConnection();
		connection.setDoOutput(true);

		connection.connect();

		OutputStreamWriter ow = new OutputStreamWriter(connection.getOutputStream());
		ow.write("string"+ URLEncoder.encode("Hello' World!", "utf-8"));
		ow.close();

		PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(outFile)));

		String line = null;
		while((line = br.readLine()) != null) {
			pw.println(line);
		}

		br.close();
		pw.close();
	}
}