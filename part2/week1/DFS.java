import java.util.*;
import java.io.*;

public class DFS<V> {
	private Set<V> visited;
	private Map<V, V> edgeTo;
	private V source;

	public DFS(Graph<V> g, V source) {
		this.source = source;
		visited = new HashSet<V>();
		edgeTo = new HashMap<V, V>();
		dfs(g, source);
	}

	private void dfs(Graph<V> g, V source) {
		visited.add(source);

		for(V vertex : g.edges(source)) {
			if(!visited.contains(vertex)) {
				edgeTo.put(vertex, source);
				dfs(g, vertex);
			}
		}
	}

	public boolean hasPath(V vertex) {
		return visited.contains(vertex);
	}

	public Iterable<V> path(V vertex) {
		if(!hasPath(vertex)) {
			return null;
		}

		Stack<V> vertices = new Stack<V>();
		vertices.push(vertex);

		V parent = vertex;
		while((parent = edgeTo.get(parent)) != null) {
			vertices.push(parent);
		}


		return vertices;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		Graph<String> g = new Graph<String>();

		String line = null;

		while((line = br.readLine()) != null) {
			String[] edgePair = line.split(" ");

			g.addEdge(edgePair[0], edgePair[1]);
		}

		br.close();

		String source = "AL";

		DFS<String> dfs = new DFS<String>(g, source);
		// for each for STACK is not LIFO in java
		for(String vertex : g.vertices()) {
			if(dfs.hasPath(vertex)) {
				pw.format("path between %s and %s%n", source, vertex);

				boolean first = true;

				for(String next : dfs.path(vertex)) {
					if(first) {
						first = false;
					} else {
						pw.format("->");
					}

					pw.format("%s", next);
				}

				pw.format("%n");
			}
		}

		pw.close();
	}
}