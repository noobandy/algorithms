import java.util.Scanner;

public class LongestSequence {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();

		int[] nums = new int[N];

		for(int i = 0; i < N; i++) {
			nums[i] = s.nextInt();
		}

		int[] len = new int[nums.length];

		for(int i = 0; i < nums.length; i++) {
			len[i] = 1;
		}
		for(int i = 0; i < nums.length - 1; i++) {
			int j = i;

			while(j < nums.length - 1 && nums[j] <= nums[j + 1]) {
				len[i] += 1;
				j++;
			}
		}

		for(int i = 0; i < len.length; i++) {
			System.out.println(len[i]);
		}

	}
}