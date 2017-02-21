import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] fractions;
    private double mean;
    private double stddev;
    private double confidenceLo;
    private double confidenceHi;


    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }
        
        this.fractions = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                int row = StdRandom.uniform(1, n + 1);
                int col = StdRandom.uniform(1, n + 1);
                percolation.open(row, col);
            }
            double fraction = (percolation.numberOfOpenSites() / (double) (n * n));
            fractions[i] = fraction;
        }

        mean = StdStats.mean(fractions);
        stddev = StdStats.stddev(fractions);

        confidenceLo = mean - ((1.96 * stddev) / Math.sqrt(trials));
        confidenceHi = mean + ((1.96 * stddev) / Math.sqrt(trials));

    }
    // sample mean of percolation threshold
    public double mean() {
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

    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean                    = " + percolationStats.mean());
        System.out.println("stddev                  = " + percolationStats.stddev());
        System.out.println("95% confidence interval = [" + percolationStats.confidenceLo() + ", " + 
            percolationStats.confidenceHi() + "]");

    }
}