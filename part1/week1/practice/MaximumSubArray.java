public class MaximumSubArray {

	public static void main(String[] args) {
		int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};

		int maxC = arr[0];
		int maxG = arr[0];

		for(int i = 1; i < arr.length; i++) {
			maxC = Math.max(arr[i], arr[i] + maxC);
			maxG = Math.max(maxG, maxC);

			System.out.format("at %d maxC: %d and maxG: %d%n", i, maxC, maxG);

		}

		System.out.println(maxG);
	}
}