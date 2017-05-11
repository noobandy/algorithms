import java.util.*;
public class GraphTest {
	public static void main(String[] args) {
		Graph.Vertex A = new Graph.Vertex("A");
		Graph.Vertex B = new Graph.Vertex("B");
		Graph.Vertex C = new Graph.Vertex("C");
		Graph.Vertex D = new Graph.Vertex("D");
		Graph.Vertex E = new Graph.Vertex("E");
		Graph.Vertex F = new Graph.Vertex("F");

		List<Graph.Vertex> vertices = new ArrayList<Graph.Vertex>();
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
			System.out.format("graph %s contains vertex %s%n", graph.hasVertex(v) ? "" : "does not", v.getElement());
		}

		for(Graph.Edge e : edges) {
			System.out.format("graph %s contains edge %s -> %s%n", graph.hasEdge(e) ? "" : "does not", 
				e.getSource().getElement(), e.getDestination().getElement());
		}


		List<Graph.Edge> pathAE = graph.getPath(A, E);

		for(Graph.Edge e : pathAE) {
			System.out.format("%s -> %s%n", e.getSource().getElement(), 
				e.getDestination().getElement());
		}
	}
}