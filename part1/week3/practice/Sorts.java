public class Sorts {

	private static <E extends Comparable<? super E>> boolean less(E first, E second) {
		return first.compareTo(second) < 0;
	}

	private static <E> void swap(E[] elements, int i, int j) {
		E temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}

	public static <E extends Comparable<? super E>> void selectionSort(E[] elements) {
		for(int i = 0; i < elements.length; i++) {
			int minIndex = i;

			for(int j = i; j < elements.length; j++) {
				if(less(elements[j], elements[minIndex])) {
					minIndex = j;
				}
			}
			if(minIndex != i) {
				swap(elements, i, minIndex);
			}

			System.out.print("[");
			for(E element: elements) {
				System.out.print(element);
				System.out.print(" ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static <E extends Comparable<? super E>> void insertionSort(E[] elements) {
		for(int i = 1; i < elements.length; i++) {
			int j = i - 1;
			E key = elements[i];

			while(j >= 0 && less(key, elements[j])) {
				elements[j + 1] = elements[j];
				j--;
			}
			elements[j + 1] = key;

			System.out.print("[");
			for(E element: elements) {
				System.out.print(element);
				System.out.print(" ");
			}
			System.out.print("]");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Integer[] nums = new Integer[] {3,1,-3,2,5,7, 3, 0};
		Sorts.selectionSort(nums);
	}
}