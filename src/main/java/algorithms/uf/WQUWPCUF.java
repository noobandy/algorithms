package algorithms.uf;
import java.util.*;

public class WQUWPCUF implements UF {

	private int[] objects;
	private int[] weights;

	public WQUWPCUF(int n) {
		super();
		objects = new int[n];
		weights = new int[n];

		for(int i = 0; i < n; i++) {
			objects[i] = i;
			weights[i] = 1;
		}
	}

	private int root(int object) {
		int curr = objects[object];
		Stack<Integer> path = new Stack<Integer>();

		while(curr != objects[curr]) {
			path.push(curr);
			curr = objects[curr];
			path.push(curr);
		}

		//compress path to flatten the tree
		while(!path.isEmpty()) {
			objects[path.pop()] = curr;
		}

		return curr;
	}

	public boolean union(int object1, int object2) {
		int rootOfObject1 = root(object1);
		int rootOfObject2 = root(object2);

		if(rootOfObject1 == rootOfObject2) {
			//already connected
			return false;
		} else {
			if(weights[rootOfObject1] >= weights[rootOfObject2]) {
				weights[rootOfObject1] = weights[rootOfObject1] + weights[rootOfObject2];
				objects[rootOfObject2] = rootOfObject1;
			} else {
				weights[rootOfObject2] = weights[rootOfObject2] + weights[rootOfObject2];
				objects[rootOfObject1] = rootOfObject2;
			}
			return true;
		}
	}

	public boolean connected(int object1, int object2) {
		return root(object1) == root(object2);
	}
}