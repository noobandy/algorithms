public class HeapSort {

	private HeapSort() {

	}


	public static <E extends Comparable<E>> void sort(E[] elements) {
		heapOrder(elements);

		int end = elements.length - 1;

		while (end > 0) {
			swap(elements, end , 0);
			end--;
			shink(elements, 0, end);
		}
	}

	private static <E extends Comparable<E>> void heapOrder(E[] elements) {
		int end = elements.length - 1;
		int start = (end - 1) / 2;

		while (start >= 0) {
			shink(elements, start, end);
			start--;
		}
	}

	private static <E extends Comparable<E>> void swap(E[] elements, int i, int j) {
		E element = elements[i];
		elements[i] = elements[j];
		elements[j] = element;
	}

	private static <E extends Comparable<E>> void  shink(E[] elements, int start, int end) {

		while (((start * 2) + 1) <= end) {
			int j = (start * 2) + 1;

			if (j < end && elements[j].compareTo(elements[j + 1]) < 0) {
				j = j + 1;
			}

			if (elements[start].compareTo(elements[j]) < 0) {
				swap(elements, start, j);
				start = j;
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {

		Integer[] elements = new Integer[20];
		for (int i = 0; i < elements.length; i++) {
			int n = (int) (Math.random() * 10);

			if (i % 2 == 0) {
				n = n * -1;
			}

			elements[i] = n;
		}

		System.out.print("Unsorted: [");
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i]);
			if (i != elements.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");

		HeapSort.sort(elements);

		System.out.print("Sorted: [");
		for (int i = 0; i < elements.length; i++) {
			System.out.print(elements[i]);
			if (i != elements.length - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}
}