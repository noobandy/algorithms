import java.util.*;

public class Percentile {


	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		double[] nums = new double[N];

		for(int i = 0; i < N; i++) {
			nums[i] = s.nextDouble();
		}

		Arrays.sort(nums);

		double P = (80.0 / 100.0) * (N + 1);

		

	}
}