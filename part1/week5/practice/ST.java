import java.util.Deque;
import java.util.LinkedList;

public class ST<K extends Comparable<K>, V> {

	private static final class Node<K, V> {
		private K key;
		private V value;
		private Node<K, V> left;
		private Node<K, V> right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	private Node<K, V> root;

	public ST() {

	}

	// add entry to symbol table
	public void put(K key, V value) {
		Node<K, V> node = new Node<K, V>(key, value);
		root = put(root, node);
	}

	private Node<K, V> put(Node<K, V> parent, Node<K, V> node) {
		if(parent == null) {
			return node;
		}

		int cmp = node.key.compareTo(parent.key);

		if(cmp < 0) {
			parent.left = put(parent.left, node);
		} else {
			parent.right = put(parent.right, node);
		}

		return parent;
	}

	// get value for key
	public V get(K key) {
		Node<K, V> node = get(root, key);

		if(node == null) {
			return null;
		} else {
			return node.value;
		}
	}

	private Node<K, V> get(Node<K, V> node, K key) {
		if(node == null) {
			return node;
		}

		int cmp = key.compareTo(node.key);

		if(cmp < 0) {
			return get(node.left, key);
		} else if(cmp > 0) {
			return get(node.right, key);
		} else {
			return node;
		}

	}

	// delete entry corresponding to key
	public void delete(K key) {
		root = delete(root, key);
	}

	private Node<K, V> delete(Node<K, V> node, K key) {
		if(node == null) {
			return null;
		}

		int cmp = key.compareTo(node.key);

		if(cmp < 0) {
			node.left = delete(node.left, key);
		} else if(cmp > 0) {
			node.right = delete(node.right, key);
		} else {

			if(node.left == null) {
				return node.right;
			}

			if(node.right == null) {
				return node.left;
			}

			Node<K, V> t = node;

			node.value = min(node.right).value;

			node.right = deleteMin(t.right);
		}

		return node;
	}

	private Node<K, V> deleteMin(Node<K, V> node) {
		if(node == null) {
			return null;
		}

		if(node.left == null) {
			return node.right;
		}

		node.left = deleteMin(node.left);

		return node;

	}

	private Node<K, V> min(Node<K, V> node) {
		if(node.left == null) {
			return null;
		}

		return min(node.left);
	}

	public Iterable<K> iterable() {
		Deque<K> queue = new LinkedList<K>();
		return queue;

	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node<K, V> node) {
		if(node != null) {
			inOrder(node.left);
			System.out.println(node.value);
			inOrder(node.right);
		}

	}

	public static void main(String[] args) {
		ST<String, String[]> st = new ST<String, String[]>();

		st.put("anandm", new String[]{"Anand", "Mohan"});

		st.put("sushmay", new String[]{"Sushma", "Yadav"});

		System.out.format("%s -> %s %s%n", "anandm", st.get("anandm")[0], st.get("anandm")[1]);
		System.out.format("%s -> %s %s%n", "sushmay", st.get("sushmay")[0], st.get("sushmay")[1]);

		st.delete("anandm");
		System.out.format("%s is %s present%n", "anandm", st.get("anandm") == null ? "not" : "");
		System.out.format("%s is %s present%n", "sushmay", st.get("sushmay") == null ? "not": "");
		st.delete("sushmay");
		System.out.format("%s is %s present%n", "anandm", st.get("anandm") == null ? "not" : "");
		System.out.format("%s is %s present%n", "sushmay", st.get("sushmay") == null ? "not": "");

		ST<Integer, Integer> nums = new ST<Integer, Integer>();

		for(Integer num : new int[] {5, 2, -4, 3, 18, 21, 19, 25}) {
			nums.put(num, num);
		}

		nums.inOrder();

		//  delete -4 (no child)
		System.out.format("delete %d%n", -4);
		nums.delete(-4);

		nums.inOrder();

		// delete 18 (single child)
		System.out.format("delete %d%n", 18);
		nums.delete(18);

		nums.inOrder();

		System.out.format("put %d%n", 12);
		nums.put(12, 12);

		nums.inOrder();

		// delete 12 (both child)
		System.out.format("delete %d%n", 12);
		nums.delete(12);

		nums.inOrder();





	}

}