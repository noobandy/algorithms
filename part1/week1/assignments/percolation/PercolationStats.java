public class PercolationStats {
	private int n;
	private int trials;
	private Percolation percolation;
	private double mean;
	private double stddev;
	private double confidenceLo;
	private double confidenceHi;

	// perform trials independent experiments on an n-by-n grid
	public PercolationStats(int n, int trials) {
		if (n <= 0 || trials <= 0) {
			throw new IllegalArgumentException();
		}
		this.n = n;
		this.trials = trials;
		percolation = new Percolation(n);
	}
	// sample mean of percolation threshold
	public double mean()  {
		return mean;
	}
	// sample standard deviation of percolation threshold
	public double stddev() {
		return stddev;
	}
	// low  endpoint of 95% confidence interval
	public double confidenceLo() {
		return confidenceLo;
	}
	// high endpoint of 95% confidence interval
	public double confidenceHi()    {
		return confidenceHi;
	}
}