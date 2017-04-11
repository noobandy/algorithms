import java.util.Scanner;

public class WQUWPCUFMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		UF uf = new WQUWPCUF(n);

		while(scanner.hasNext()) {
			int p = scanner.nextInt();
			int q = scanner.nextInt();

			if(uf.connected(p, q)) {
				System.out.format("%d and %d are already connected.%n", p, q);
			} else {
				System.out.format("union %d and %d.%n", p, q);
				uf.union(p, q);
			}
		}
		
	}

}