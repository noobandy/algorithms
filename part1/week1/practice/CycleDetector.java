import java.util.*;

public class CycleDetector {
	private int[] ids;
	private int[] ranks;

	public CycleDetector(int vertices) {
		ids = new int[vertices];
		ranks = new int[vertices];

		for(int i = 0; i < vertices; i++) {
			ids[i] = i;
		}
	}
	private int root(int o) {
		int curr = ids[o];

		while(curr != ids[curr]) {
			
			ids[curr] = ids[ids[curr]];

			curr = ids[curr];
		}

		return curr;
	}
	public boolean edge(int s, int d) {
		int rootS = root(s);
		int rootD = root(d);

		if(rootS == rootD) {
			return false;
		} else {
			if(ranks[rootS] == ranks[rootD]) {
				// same rank
				ids[rootD] = ids[rootS];
				ranks[rootS] = ranks[rootS] + 1;
			} else if(ranks[rootS] > ranks[rootD]) {
				// rank s > rank d
				ids[rootD] = ids[rootS];
			} else {
				// rank s < rank d
				ids[rootS] = ids[rootD];
			}
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int vertices = scanner.nextInt();
		CycleDetector cd = new CycleDetector(vertices);

		while(scanner.hasNext()) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			if(!cd.edge(source, dest)) {
				System.out.format("edge %d --- %d will create a cycle.%n", source, dest);
				break;
			}
		}

		scanner.close();
	}
}