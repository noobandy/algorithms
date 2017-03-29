import java.util.Deque;
import java.util.LinkedList;

public class ST<K extends Comparable<K>, V> {

	public static final class Entry<K, V> {
		private K key;
		private V value;
		private Entry<K, V> left;
		private Entry<K, V> right;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	private Entry<K, V> root;

	public ST() {

	}

	// add entry to symbol table
	public void put(K key, V value) {
		Entry<K, V> entry = new Entry<K, V>(key, value);
		root = put(root, entry);
	}

	private Entry<K, V> put(Entry<K, V> parent, Entry<K, V> entry) {
		if(parent == null) {
			return entry;
		}

		int cmp = entry.key.compareTo(parent.key);

		if(cmp < 0) {
			parent.left = put(parent.left, entry);
		} else if(cmp > 0) {
			parent.right = put(parent.right, entry);
		} else {
			parent.value = entry.value;
		}

		return parent;
	}

	// get value for key
	public V get(K key) {
		Entry<K, V> entry = get(root, key);

		if(entry == null) {
			return null;
		} else {
			return entry.value;
		}
	}

	private Entry<K, V> get(Entry<K, V> entry, K key) {
		if(entry == null) {
			return entry;
		}

		int cmp = key.compareTo(entry.key);

		if(cmp < 0) {
			return get(entry.left, key);
		} else if(cmp > 0) {
			return get(entry.right, key);
		} else {
			return entry;
		}

	}

	// delete entry corresponding to key
	public void delete(K key) {
		root = delete(root, key);
	}

	private Entry<K, V> delete(Entry<K, V> entry, K key) {
		if(entry == null) {
			return null;
		}

		int cmp = key.compareTo(entry.key);

		if(cmp < 0) {
			entry.left = delete(entry.left, key);
		} else if(cmp > 0) {
			entry.right = delete(entry.right, key);
		} else {

			if(entry.left == null) {
				return entry.right;
			}

			if(entry.right == null) {
				return entry.left;
			}

			Entry<K, V> min = min(entry.right);
			entry.value = min.value;
			entry.key = min.key;

			entry.right = deleteMin(entry.right);
		}

		return entry;
	}

	private Entry<K, V> deleteMin(Entry<K, V> entry) {
		if(entry == null) {
			return null;
		}

		if(entry.left == null) {
			return entry.right;
		}

		entry.left = deleteMin(entry.left);

		return entry;

	}

	private Entry<K, V> min(Entry<K, V> entry) {
		if(entry.left == null) {
			return null;
		}

		return min(entry.left);
	}

	public Iterable<Entry<K, V>> iterable() {
		Deque<Entry<K, V>> queue = new LinkedList<Entry<K, V>>();
		inorder(root, queue);
		return queue;

	}

	private void inorder(Entry<K, V> entry, Deque<Entry<K, V>> queue) {
		if(entry != null) {
			inorder(entry.left, queue);
			queue.addLast(entry);
			inorder(entry.right, queue);
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

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		//  delete -4 (no child)
		System.out.format("delete %d%n", -4);
		nums.delete(-4);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		// delete 18 (single child)
		System.out.format("delete %d%n", 18);
		nums.delete(18);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		System.out.format("put %d%n", 12);
		nums.put(12, 12);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		System.out.format("put %d%n", 13);
		nums.put(12, 13);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		// delete 12 (both child)
		System.out.format("delete %d%n", 12);
		nums.delete(12);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

		// delete 19 (both child)
		System.out.format("delete %d%n", 19);
		nums.delete(19);

		for(Entry<Integer, Integer> entry : nums.iterable()) {
			System.out.format("%d -> %d%n", entry.getKey(), entry.getValue());
		}

	}

}