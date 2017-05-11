import java.util.*;

public class Graph {
	private List<Vertex> vertices;
	private List<Edge> edges;

	public static final class Vertex {
		private Object element;

		public Vertex(Object element) {
			if(element == null) {
				throw new IllegalArgumentException("element should not be null");
			}
			this.element = element;
		}

		public Object getElement() {
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
		private Vertex source;
		private Vertex destination;

		public Edge(Vertex source, Vertex destination) {
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

	public Graph(List<Vertex> vertices, List<Edge> edges) {
		if(vertices == null) {
			throw new IllegalArgumentException("vertices should not be null");
		}

		if(edges == null) {
			throw new IllegalArgumentException("edges should not be null");
		}

		this.vertices = vertices;
		this.edges = edges;
	}

	public void addVertex(Vertex vertex) {
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
		return !bfs(source, destination).isEmpty();
	}

	public List<Edge> getPath(Vertex source, Vertex destination) {

		return bfs(source, destination);
	}

	private static final class SearchVertex {
		private Vertex vertex;
		private SearchVertex prev;

		public SearchVertex(Vertex vertex, SearchVertex prev) {
			this.vertex = vertex;
			this.prev = prev;
		}

		public boolean equals(Object other) {
			if(other == null) {
				return false;
			}

			if(this == other) {
				return true;
			}

			if(other instanceof SearchVertex) {
				SearchVertex otherSearchVertex = (SearchVertex) other;
				return vertex.equals(otherSearchVertex.vertex);
			}

			return false;
		}
	}

	private List<Edge> bfs(Vertex source, Vertex destination) {
		Deque<SearchVertex> queue = new LinkedList<SearchVertex>();
		List<Vertex> visited = new ArrayList<Vertex>();

		List<Edge> path = new ArrayList<Edge>();
		

		queue.addLast(new SearchVertex(source, null));

		while(!queue.isEmpty()) {
			SearchVertex search = queue.removeFirst();
			
			if(search.vertex.equals(destination)) {
				Deque<Vertex> trail = new LinkedList<Vertex>();
				while(search != null) {
					trail.addLast(search.vertex);
					search = search.prev;
				}
				Vertex pSource = trail.removeLast();
				Vertex pDestination = null;

				while(!trail.isEmpty()) {
					pDestination = trail.removeLast();
					path.add(new Edge(pSource, pDestination));
					pSource = pDestination;
				}

				break;
			}

			visited.add(search.vertex);

			List<Vertex> neighbours = neighbours(search.vertex);
			for(Vertex neighbour: neighbours) {
				SearchVertex newSearchVertex = new SearchVertex(neighbour, search);
				if(!visited.contains(newSearchVertex.vertex) && !queue.contains(newSearchVertex)) {
					queue.addLast(newSearchVertex);	
				}
			}
		}

		return path;
	}

	private List<Edge> dfs(Vertex source, Vertex destination) {
		Deque<SearchVertex> stack = new LinkedList<SearchVertex>();
		List<Vertex> visited = new ArrayList<Vertex>();

		List<Edge> path = new ArrayList<Edge>();
		

		stack.addLast(new SearchVertex(source, null));

		while(!stack.isEmpty()) {
			SearchVertex search = stack.removeLast();
			
			if(search.vertex.equals(destination)) {
				Deque<Vertex> trail = new LinkedList<Vertex>();
				while(search != null) {
					trail.addLast(search.vertex);
					search = search.prev;
				}
				Vertex pSource = trail.removeLast();
				Vertex pDestination = null;

				while(!trail.isEmpty()) {
					pDestination = trail.removeLast();
					path.add(new Edge(pSource, pDestination));
					pSource = pDestination;
				}

				break;
			}

			visited.add(search.vertex);

			List<Vertex> neighbours = neighbours(search.vertex);
			for(Vertex neighbour: neighbours) {
				SearchVertex newSearchVertex = new SearchVertex(neighbour, search);
				if(!visited.contains(newSearchVertex.vertex) && !stack.contains(newSearchVertex)) {
					stack.addLast(newSearchVertex);	
				}
			}
		}

		return path;
	}

	private List<Vertex> neighbours(Vertex vertex) {
		List<Vertex> neighbours = new ArrayList<Vertex>();
		for(Edge edge : edges) {
			if(edge.source.equals(vertex)) {
				neighbours.add(edge.destination);
			}
		}

		return neighbours;
	}
}