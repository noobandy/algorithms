public class QuickUnionImprovedUF implements UF {
	private int objects[];
	private int weights[];

	public QuickUnionImprovedUF(int n) {
		super();
		objects = new int[n];
		weights = new int[n];

		for (int i = 0; i < n; i++) {
			objects[i] = i;
			weights[i] = 1;
		}
	}

	private int root(int object) {
		int current = objects[object];

		while (current != objects[current]) {
			current = objects[current];
		}

		return current;
	}

	public boolean union(int object1, int object2) {
		int rootOfObject1 = root(object1);
		int rootOfObject2 = root(object2);

		if (rootOfObject1 == rootOfObject2) {
			return false;
		} else {
			if (weights[rootOfObject1] >= weights[rootOfObject2]) {
				weights[rootOfObject1] = weights[rootOfObject1] + weights[rootOfObject2];
				objects[object2] = rootOfObject1;
			} else {
				weights[rootOfObject2] = weights[rootOfObject2] + weights[rootOfObject2];
				objects[object1] = rootOfObject2;
			}
			return true;
		}
	}

	public boolean connected(int object1, int object2) {
		return root(object1) == root(object2);
	}
}