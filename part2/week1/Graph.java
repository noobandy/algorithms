import java.util.*;

public class Graph<V> {

	private Map<V, Integer> vertexIndexMap;
	private List<V> vertices;
	private List<List<V>> adjcList;
	
	public Graph() {
		vertexIndexMap = new HashMap<V, Integer>();
		vertices = new ArrayList<V>();
		adjcList = new ArrayList<List<V>>();
	}

	public List<V> vertices() {
		return vertices;
	}

	public void addEdge(V source, V dest) {
		Integer indexS = vertexIndexMap.get(source);
		if(indexS == null) {
			indexS = vertices.size();
			vertices.add(source);
			vertexIndexMap.put(source, indexS);
			adjcList.add(indexS, new ArrayList<V>());
		}

		Integer indexD = vertexIndexMap.get(dest);
		if(indexD == null) {
			indexD = vertices.size();
			vertices.add(dest);
			vertexIndexMap.put(dest, indexD);
			adjcList.add(indexD, new ArrayList<V>());
		}

		adjcList.get(indexS).add(dest);
		adjcList.get(indexD).add(source);

	}

	public Iterable<V> edges(V source) {
		return adjcList.get(vertexIndexMap.get(source));
	}
}