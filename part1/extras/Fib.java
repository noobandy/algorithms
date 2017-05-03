import java.math.BigInteger;

public class Fib {
	public static void main(String[] args) {
		int F = Integer.parseInt(args[0]);
		if (F >= 0) {
			BigInteger F0 = new BigInteger("0");
			BigInteger F1 = new BigInteger("1");
			if (F == 0) {
				System.out.println(F0.toString());
			} else if ( F == 1) {
				System.out.println(F1.toString());
			} else {
				for (int i = 2; i <= F; i++) {
					BigInteger tmp = F0.add(F1);
					F0 = F1;
					F1 = tmp;
				}

				System.out.println(F1.toString());
			}

		}

	}
}