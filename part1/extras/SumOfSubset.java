public class SumOfSubset {

	public static void main(String[] args) {
		int[] coins = new int[] {1, 3, 5};
		int S = 11;
		int[] mins = new int[S + 1];
		int[][] coinsInMins = new int[S + 1][]; 
		mins[0] = 0;
		coinsInMins[0] = new int[] {0};

		for(int i = 1; i < mins.length; i++) {
			mins[i] = Integer.MAX_VALUE;
		}

		for(int i = 1; i < mins.length; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i && mins[i - coins[j]] + 1 < mins[i]) {
					mins[i] = mins[i - coins[j]] + 1;
					coinsInMins[i] = new int[coinsInMins[i - coins[j]].length + 1];
					for(int k = 0; k < coinsInMins[i].length - 1; k++) {
						coinsInMins[i][k] = coinsInMins[i - coins[j]][k];
					}

					coinsInMins[i][coinsInMins[i].length - 1] = coins[j];
				}
			}
		}


		for(int i = 0; i < mins.length; i++) {
			System.out.println(i+ " : " + mins[i]);
			for(int j = 0 ; j < coinsInMins[i].length; j++) {
				System.out.print(coinsInMins[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

	}
}