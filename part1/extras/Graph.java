import java.util.*;

public class Graph {
	private List<Vertex<?>> vertices;
	private List<Edge> edges;

	public static final class Vertex<E> {
		private E element;

		public Vertex(E element) {
			if(element == null) {
				throw new IllegalArgumentException("element should not be null");
			}
			this.element = element;
		}

		public E getElement() {
			return element;
		}

		public boolean equals(Object other) {
			if(other == null) {
				return false;
			}

			if(this == other) {
				return true;
			}

			if(other instanceof Vertex) {
				Vertex otherVertex = (Vertex) other;
				return element.equals(otherVertex.element);
			}

			return false;
		}
	}

	public static final class Edge {
		private Vertex<?> source;
		private Vertex<?> destination;

		public Edge(Vertex<?> source, Vertex<?> destination) {
			if(source == null) {
				throw new IllegalArgumentException("source should not be null");
			}

			if(destination == null) {
				throw new IllegalArgumentException("destination should not ne null");
			}

			this.source = source;
			this.destination = destination;
		}

		public Vertex getSource() {
			return source;
		}

		public Vertex getDestination() {
			return destination;
		}

		public boolean equals(Object other) {
			if(other == null) {
				return false;
			}

			if(this == other) {
				return true;
			}

			if(other instanceof Edge) {
				Edge otherEdge = (Edge) other;
				return source.equals(otherEdge.source) && destination.equals(otherEdge.destination);
			}

			return false;
		}
	}

	public Graph() {
		this(new ArrayList<Vertex>(), new ArrayList<Edge>());
	}

	public Graph(List<Vertex<?>> vertices, List<Edge> edges) {
		if(vertices == null) {
			throw new IllegalArgumentException("vertices should not be null");
		}

		if(edges == null) {
			throw new IllegalArgumentException("edges should not be null");
		}

		this.vertices = vertices;
		this.edges = edges;
	}

	public void addVertex(Vertex<?> vertex) {
		if(!vertices.contains(vertex)) {
			this.vertices.add(vertex);	
		}
	}

	public void removeVertex(Vertex vertex) {
		Iterator<Edge> iterator = edges.iterator();
		while(iterator.hasNext()) {
			Edge edge  = iterator.next();
			if(edge.source.equals(vertex) || edge.source.equals(vertex)) {
				iterator.remove();
			}
		}

		this.vertices.remove(vertex);
	}

	public boolean hasVertex(Vertex vertex) {
		return vertices.contains(vertex);
	}

	public void addEdge(Edge edge) {
		if(!edges.contains(edge)) {
			this.edges.add(edge);
		}
	}

	public void removeEdge(Edge edge) {
		this.edges.remove(edge);
	}

	public boolean hasEdge(Edge edge) {
		return edges.contains(edge);
	}

	public boolean isConnected(Vertex source, Vertex destination) {
		return false;
	}

	public List<Edge> getPath(Vertex source, Vertex destination) {
		return new ArrayList<Edge>();
	}
}