package algorithms.uf;
import java.util.*;

public class WQUWPCUFMain {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		UF uf = new WQUWPCUF(n);

		int commands = scanner.nextInt();

		for(int i = 0; i < commands; i++) {
			uf.union(scanner.nextInt(), scanner.nextInt());
		}

		int queries = scanner.nextInt();

		for(int i = 0; i < queries; i++) {
			int object1 = scanner.nextInt();
			int object2 = scanner.nextInt();
			boolean connected = uf.connected(object1, object2);
			System.out.format("%d and % d are %s connected.%n", object1, object2, connected ? "" : "not");
		}
		
	}

}