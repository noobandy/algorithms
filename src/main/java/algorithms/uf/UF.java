package algorithms.uf;

public interface UF {

	boolean union(int object1, int object2);

	boolean connected(int object1, int object2);
}