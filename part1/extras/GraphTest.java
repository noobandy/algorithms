import java.util.*;
public class GraphTest {
	public static void main(String[] args) {
		Graph.Vertex<String> A = new Graph.Vertex<String>("A");
		Graph.Vertex<String> B = new Graph.Vertex<String>("B");
		Graph.Vertex<String> C = new Graph.Vertex<String>("C");
		Graph.Vertex<String> D = new Graph.Vertex<String>("D");
		Graph.Vertex<String> E = new Graph.Vertex<String>("E");
		Graph.Vertex<String> F = new Graph.Vertex<String>("F");

		List<Graph.Vertex<String>> vertices = new ArrayList<Graph.Vertex<String>>();
		vertices.add(A);
		vertices.add(B);
		vertices.add(C);
		vertices.add(D);
		vertices.add(E);
		vertices.add(F);

		List<Graph.Edge> edges = new ArrayList<Graph.Edge>();
		Graph.Edge AB = new Graph.Edge(A, B);
		Graph.Edge BA = new Graph.Edge(B, A);

		Graph.Edge AC = new Graph.Edge(A, C);
		Graph.Edge CA = new Graph.Edge(C, A);

		Graph.Edge AD = new Graph.Edge(A, D);
		Graph.Edge DA = new Graph.Edge(D, A);

		Graph.Edge BC = new Graph.Edge(B, C);
		Graph.Edge CB = new Graph.Edge(C, B);

		Graph.Edge BE = new Graph.Edge(B, E);
		Graph.Edge EB = new Graph.Edge(E, B);

		Graph.Edge DE = new Graph.Edge(D, E);
		Graph.Edge ED = new Graph.Edge(E, D);

		Graph.Edge DF = new Graph.Edge(D, F);
		Graph.Edge FD = new Graph.Edge(F, D);


		edges.add(AB);
		edges.add(BA);

		edges.add(AC);
		edges.add(CA);
		
		edges.add(AD);
		edges.add(DA);

		edges.add(BC);
		edges.add(CB);

		edges.add(BE);
		edges.add(EB);

		edges.add(DE);
		edges.add(ED);

		edges.add(DF);
		edges.add(FD);

		Graph graph = new Graph(vertices, edges);

		for(Graph.Vertex v : vertices) {
			System.out.format("graph %s contains vertex %s.%n", graph.hasGraph.Vertex(v) ? "" : "does not", v.getElement());
		}

		for(Graph.Edge e : edges) {
			System.out.format("graph %s contains edge %s -> %s .%n", graph.hasGraph.Edge(e) ? "" : "does not", 
				e.getSource().getElement(), e.getDestination().getElement());
		}

	}
}