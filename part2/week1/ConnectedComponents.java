import java.io.*;
import java.util.*;

public class ConnectedComponents<V> {
	private Map<V, Integer> components;
	private int id;
	private Set<V> visited;
	private List<List<V>> componentsTrail;

	public ConnectedComponents(Graph<V> g) {
		components = new HashMap<V, Integer>();
		visited = new HashSet<V>();
		componentsTrail = new ArrayList<List<V>>();

		for (V vertex : g.vertices()) {
			if (!visited.contains(vertex)) {
				id++;
				List<V> trail = new ArrayList<V>();
				dfs(g, vertex, trail);
				componentsTrail.add(trail);
			}
		}
	}

	public int components() {
		return id;
	}

	public boolean connected(V source, V dest) {
		return components.get(source) == components.get(dest);
	}

	public List<List<V>> componentsTrail() {
		return componentsTrail;
	}

	private void dfs(Graph<V> g, V source, List<V> trail) {
		visited.add(source);
		components.put(source, id);
		trail.add(source);

		for (V adjcent : g.edges(source)) {
			if (!visited.contains(adjcent)) {
				dfs(g, adjcent, trail);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		Graph<String> g = new Graph<String>();

		String line = null;

		while ((line = br.readLine()) != null) {
			String[] edgePair = line.split(" ");

			g.addEdge(edgePair[0], edgePair[1]);
		}

		br.close();

		ConnectedComponents<String> cc = new ConnectedComponents<String>(g);

		pw.format("there are %d connected components%n", cc.components());

		for(List<String> trail : cc.componentsTrail()) {
			boolean first = true;
			pw.format("{");
			for(String vertex : trail) {
				if(first) {
					first = false;
				} else {
					pw.format(", ");
				}

				pw.format("%s", vertex);
			}
			pw.format("}%n"); 
		}
		pw.close();
	}
}