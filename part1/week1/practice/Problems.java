import java.util.Arrays;

public class Problems {

	public static  void fillMatrix(Integer[][] matrix) {
		int next = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				matrix[i][j] =  next++;
			}
		}
	}

	public static <T> void printMatrix(T[][] matrix) {

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix.length; j++) {
				if(j > 0) {
					System.out.format("%s", " ");
				}

				System.out.format("%s", matrix[i][j].toString());	
			}
			System.out.format("%n");
		}
	}

	public static <T> void transposition(T[][] matrix) {
		

		for(int i = 0; i < matrix.length; i++) {
			for(int j = i + 1; j < matrix.length; j++) {
				T temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp; 
			}
		}
	}

	public static int lg(int base, int num) {
		//for input 0 
		int result = 0;
		int next = 1;

		while(true) {
			next *= base;
			if(next <= num) {
				result++;
			} else {
				break;
			}
		}

		return result;
	}

	public static long fib(int n) {
		if(n == 0) {
			return 1;
		}

		if(n == 1) {
			return 1;
		}

		return fib(n - 1) + fib(n -2);
	}

	private static long[] fibs = new long[100];

	static {
		fibs[0] = 1;
		fibs[1] = 1;
	}

	public static long fibImproved(int n) {
		if(fibs[n] > 0) {
			return	fibs[n];
		}

		long fib = fibImproved(n - 1) + fibImproved(n - 2);

		fibs[n] = fib;

		return fib;
	}

	public static long fact(int n) {
		if(n == 0) {
			return 1;
		}

		return n * fact(n - 1);
	}
	
	public static int gcd(int a, int b) {
		// a > b
		System.out.format("a: %d, b: %d%n", a, b);

		if((a % b) == 0) {
			return b;
		}

		return gcd(b, a % b);
	} 

	public static int[] histogram(int[] arr, int m) {
		int[] result = new int[m];

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] >= 0 && arr[i] < m) {
				result[arr[i]]++;
			}
		}

		return result;
	}


	public static void main(String[] args) {
		Integer[][] matrix = new Integer[3][3];
		fillMatrix(matrix);
		System.out.println("matrix");

		printMatrix(matrix);
		
		transposition(matrix);

		System.out.println("transposition");
		printMatrix(matrix);

		int base  = 2;
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 1, lg(base, 1));
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 8, lg(base, 8));
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 9, lg(base, 9));

		base  = 10;
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 1, lg(base, 1));
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 100, lg(base, 100));
		System.out.format("lg base %d of %d to nearest int is %d%n", base, 102, lg(base, 102));
		
		int[] entries = new int[] {0, -1, 6, 0, 1, 2, 3, 4, 5, 0, 1, 3};
		int m = 6;
		System.out.format("histogram of %s for %d is %s%n", Arrays.toString(entries), m, Arrays.toString(histogram(entries, m))); 
	
		for(int i = 0; i <= 90; i++) {
			// way too slow uncomment to check
			//System.out.format("fib of %d is %d%n", i, fib(i));
			System.out.format("fib of %d is %d%n", i, fibImproved(i));
		}

		for(int i = 0; i <= 20; i++) {
			// way too slow uncomment to check
			System.out.format("factorial of %d is %d%n", i, fact(i));
			//System.out.format("fib of %d is %d%n", i, fibImproved(i));
		}

		int a = 1234567;
		int b = 1111111;
		
		System.out.format("gcd of %d and %d is %d%n", a, b, gcd(a, b));

		a = 27;
		b = 16;
		System.out.format("gcd of %d and %d is %d%n", a, b, gcd(a, b));

		a = 36;
		b = 27;
		System.out.format("gcd of %d and %d is %d%n", a, b, gcd(a, b));
	}
}