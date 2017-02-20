package algorithms.uf;

public class QuickUnionUF implements UF {

	private int objects[];

	public QuickUnionUF(int n) {
		super();
		objects = new int[n];
		for(int i = 0; i < n; i++) {
			objects[i] = i;
		}
	}

	private int root(int object) {
		int current = object;
		while(objects[current] != current) {
			current = objects[current];
		}
		return current;
	}

	public boolean union(int object1, int object2) {
		int rootObject1 = root(object1);
		int rootObject2 = root(object2);
		if(rootObject1 == rootObject2) {
			//already connected
			return false;
		} else {
			objects[rootObject1] = rootObject2; 
			return true;
		}
	}

	public boolean connected(int object1, int object2) {
		int rootObject1 = root(object1);
		int rootObject2 = root(object2);
		return rootObject1 == rootObject2;
	}
}