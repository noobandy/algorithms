public class Regression {

	public Regression(double[] independent, double[] dependent) {
		double sumI = 0;
		for(int i = 0; i < independent.length; i++) {
			sumI += independent[i]; 
		}

		double sumD = 0;
		for(int i = 0; i < dependent.length; i++) {
			sumI += dependent[i]; 
		}

		double meanI = sumI / independent.length;
		double meanD = sumD / dependent.length;

		double[] varI = new double[independent.length];
		
		for(int i = 0; i < independent.length; i++) {
			varI[i] = independent[i] - meanI;
		}

		double[] varD = new double[independent.length];
		
		for(int i = 0; i < independent.length; i++) {
			varD[i] = dependent[i] - meanD;
		}

	}

	public double coefficientOfDetermination() {
		return 0;
	}

	public double predict(int independent) {
		return 0;
	}
}