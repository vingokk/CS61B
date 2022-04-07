package hw2;
import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    private Percolation perObject;
    private int numExperiments;
    private double fraction[]; // the array storing fractions in every experiment

    /** Performs T independent experiments on an N-by-N grid. */
    public PercolationStats(int N, int T, PercolationFactory pf) {
        numExperiments = T;
        fraction = new double[T];
        for (int i = 0; i < T; i += 1) {
            perObject = pf.make(N);
            for (int j = 0; j < N * N; j += 1) {
                int x = StdRandom.uniform(N);
                int y = StdRandom.uniform(N);
                perObject.open(y, x);
                if (perObject.percolates()) {
                    break;
                }
            }
            int numOpen = perObject.numberOfOpenSites();
            fraction[i] = ((double) numOpen) / (N * N);
        }
    }
    /** Returns sample mean of percolation threshold/ */
    public double mean() {
        return StdStats.mean(fraction);
    }

    /** Returns sample standard deviation of percolation threshold. */
    public double stddev() {
        return StdStats.stddev(fraction);
    }

    /** Returns low endpoint of 95% confidence interval. */
    public double confidenceLow() {
        return mean() - 1.96 * stddev() / Math.sqrt(numExperiments);
    }

    /** Returns high endpoint of 95% confidence interval. */
    public double confidenceHigh() {
        return mean() + 1.96 * stddev() / Math.sqrt(numExperiments);
    }

    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats s = new PercolationStats(20, 10000, pf);
        System.out.println(s.mean());
        System.out.println(s.stddev());
        System.out.println(s.confidenceHigh());
        System.out.println(s.confidenceLow());
    }
}
