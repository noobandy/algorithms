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

	public void delete(E element) {
		root = delete(root, element);
	}

	private Node<E> delete(Node<E> node, E element) {
		if(node == null) {
			return null;
		}

		int cmp = element.compareTo(node.element);

		if(cmp < 0) {
			node.left = delete(node.left, element);
		} else if(cmp > 0) {
			node.right = delete(node.right, element);
		} else {
			if(node.left == null) {
				return node.left;
			}

			if(node.right == null) {
				return node.right;
			}

			Node t = node;

			node = min(node.right);

			node.right = deleteMin(t.right);

			node.left = t.left

		}

		return node;
	}

	private Node<E> min(Node<E> node) {
		if(node.left == null) {
			return node;
		}

		min(node.left);
	}

	private Node<E> max(Node<E> node) {
		if(node.right == null) {
			return node;
		}

		max(node.right);
	}

	private Node<E> deleteMin(Node<E> node) {
		if(node.left == null) {
			return node.right;
		}

		node.left = deleteMin(node.left);

		return node;
	}

	private Node<E> deleteMax(Node<E> node) {
		if(node.right == null) {
			return node.left;
		}

		node.right = deleteMax(node.right);

		return node;
	}



	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return root == null;
	}


}