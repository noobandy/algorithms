public class BST<E extends Comparable<E>> {

	private int size;
	private Node<E> root;

	private static Node<E> {
		private E element;
		private Node<E> left;
		private Node<E> right;

		public Node(E element) {
			this.element = element;
		}
	}

	public BST() {

	}

	public void add(E element) {
		root = insert(root, element);

		size++;
	}

	private Node<E> insert(Node<E> node, E element) {
		if (node == null) {
			return new Node<E>(element);
		}
		int cmp = element.compareTo(node.element);

		if (cmp < 0) {
			node.left = insert(node.left, element);
		} else {
			node.right = insert(node.right, element);
		}

		return node;
	}

	public boolean contains(E element) {
		return find(root, element) != null;
	}


	private Node<E> find(Node<E> node, E element) {
		if (node == null) {
			return node;
		}

		int cmp = element.compareTo(node.element);

		if (cmp < 0) {
			return find(node.left, element);
		} else if (cmp > 0) {
			return find(node.left, element);
		} else {
			return node;
		}
	}

	public void remove(E element) {
		Node<E> parent = null;
		Node<E> cur = root;

		while (cur != null) {
			prev = cur;
			int cmp = element.compareTo(cur.element);
			if (cmp < 0) {
				cur = cur.left;
			} else if (cmp > 0) {
				cur = cur.right;
			} else {
				if (cur.left == null && cur.right) {
					if (prev.left == cur) {
						prev.left = null;
					}

					if (prev.right = cur) {
						prev.right = null;
					}
				} else if (cur.left == null) {
					if (prev.left == cur) {
						prev.left = null;
					}

					if (prev.right = cur) {
						prev.right = null;
					}
				} else if (cur.right == null) {
					if(prev.left == cur) {
						prev.left = null;
					}

					if(prev.right = cur) {
						prev.right = null;
					}
				} else {

				}
				size--;
				break;
			}
		}
	}

	public E min() {
		if (isEmpty()) {
			return null;
		}

		Node<E> cur = root;
		while (cur.left != null) {
			cur = cur.left;
		}

		return cur.element;
	}

	public E max() {
		if (isEmpty()) {
			return null;
		}

		Node<E> cur = root;
		while (cur.right != null) {
			cur = cur.right;
		}

		return cur.element;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return root == null;
	}


}