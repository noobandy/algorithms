package wsclient;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import ws.*;

public class SOAPPublisherClient {

	public static void main(String[] args) throws MalformedURLException {
		if(args.length > 0) {
			String siteUrl = args[0];
			URL wsdlURL = new URL("http://localhost:8888/ws/alexa?wsdl");
			//check above URL in browser, you should see WSDL file
			
			//creating QName using targetNamespace and name
			QName qname = new QName("http://ws/", "AlexaService"); 
			
			Service service = Service.create(wsdlURL, qname);  
			
			//We need to pass interface and model beans to client
			IAlexa alexa = service.getPort(IAlexa.class);
			AlexaQueryResult result = alexa.query(siteUrl.trim());
			result.print();
		} else {
			System.out.println("site url missing");
			System.exit(1);
		}
		

	}

}