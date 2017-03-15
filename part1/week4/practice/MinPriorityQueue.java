public class MinPriorityQueue<E extends Comparable<E>> {

	private static int INITIAL_CAPACITY = 10;

	private E[] elements;
	private int N;

	public MinPriorityQueue() {
		elements = (E[]) new Comparable[INITIAL_CAPACITY];
		N = -1;
	}

	public int size() {
		return N + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void add(E element) {
		if(N == elements.length - 1) {
			elements = resize(elements, elements.length * 2);
		}

		elements[++N] = element;

		swim(N);
	}

	public E remove() {
		if(isEmpty()) {
			return null;
		}

		E element = elements[0];
		swap(elements, 0, N);
		elements[N--] = null;

		shink(0);

		if(N == (elements.length / 4) - 1) {
			elements = resize(elements, elements.length / 2);
		}

		return element;
	}

	public E min() {
		if(isEmpty()) {
			return null;
		}

		return elements[0];
	}

	private void swim(int k) {

		while(k > 0 && elements[(k - 1) / 2].compareTo(elements[k]) > 0) {
			swap(elements, (k - 1) / 2, k);

			k = (k - 1) / 2;
		}
	}

	private void shink(int k) {
		while((k * 2 + 1) <= N) {
			int j = 2 * k + 1;
			if(j < N && elements[j].compareTo(elements[j + 1]) > 0) {
				j = j + 1;
			}

			if(elements[j].compareTo(elements[k]) < 0) {
				swap(elements, j, k);
				k = j;
			} else {
				break;
			}
		}
	}

	private void swap(E[] elements, int i, int j) {
		E tmp = elements[i];
		elements[i] = elements[j];
		elements[j] = tmp;
	}

	private E[] resize(E[] elements, int newSize) {
		E[] tmp = (E[]) new Comparable[newSize];

		for(int i = 0; i < tmp.length && i < elements.length; i++) {
			tmp[i] = elements[i];
		}

		return tmp;
	}

	public static void main(String[] args) {
		MinPriorityQueue<Integer> queue = new MinPriorityQueue<Integer>();

		for(int i = 0; i < 20; i++) {
			int n = (int) (Math.random() * 10);
			System.out.format("add: %d%n", n);
			queue.add(n);
			System.out.format("size: %d%n", queue.size());
			System.out.format("min: %d%n", queue.min());
		}

		while(!queue.isEmpty()) {
			System.out.format("remove: %d%n", queue.remove());
			System.out.format("size: %d%n", queue.size());
		}
	}

}