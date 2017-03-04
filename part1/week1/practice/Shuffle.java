import edu.princeton.cs.algs4.StdRandom;
public class Shuffle {

	public static <E> void swap(E[] elements, int i, int j) {
		E temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp; 
	}

	public static <E> void suffle(E[] elements) {
		for(int i = elements.length; i > 0; i--) {
			int j = StdRandom.uniform(i);
			swap(elements, i - 1, j);
		}
	}

	public static void main(String[] args) {
		int n = 3;
	 	Integer[] nums = new Integer[n];

	 	for(int i = 0; i < n; i++) {
	 		nums[i] = i + 1;
	 	}

	 	Shuffle.suffle(nums);

	 	for(int i = 0; i < n; i++) {
	 		System.out.println(nums[i]);
	 	}

	 } 
}