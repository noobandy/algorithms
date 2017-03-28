import java.util.Math;

public class MathUtils {

	public static final boolean isPrime(int n) {
		int sqrt = Math.floor(Math.sqrt(n));

		for(int i = 2; i <= sqrt; i = (i * 2) + 1) {
			if(n % i == 0) {
				return false;
			}
		}

		return false;
	}


	public static final boolean[] primes(int n) {
		boolean[] primes = new boolean[n + 1];
		primes[0] = true;
		primes[1] = true;
		primes[2] = true;

		int sqrt = Math.floor(Math.sqrt(n));

		for(int i = 3; )
	}

	public static void main(String[] args) {
		
	}
}