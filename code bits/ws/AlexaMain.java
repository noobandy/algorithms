package ws;

public class AlexaMain {

	public static void main(String[] args) {
		IAlexa alexa = new Alexa();
		if(args.length > 0) {
			String siteUrl = args[0];
			AlexaQueryResult result = alexa.query(siteUrl.trim());
			result.print();
		} else {
			System.out.println("site url missing");
			System.exit(1);
		}
		
	}
}