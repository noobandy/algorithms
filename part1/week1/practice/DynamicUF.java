import java.util.Scanner;
import java.util.Arrays;

public class DynamicUF {

    private static final int INITIAL_SIZE = 5;

    private int N;
    private int[] sites;
    private int[] weights;

    public DynamicUF() {
        this(INITIAL_SIZE);
    }

    public DynamicUF(int size) {
        N = size;
        sites = new int[size];
        weights = new int[size];

        for (int i = 0; i < size; i++) {
            sites[i] = i;
            weights[i] = 1;
        }
    }


    private int root(int p) {
        int root = p;
        // find root
        while (root != sites[root]) {
            root = sites[root];
        }

        // path compression by making all the sites to point directly to root
        while (p != root) {
            int newP = sites[p];
            sites[p] = root;
            p = newP;
        }

        return root;
    }

    private void ensureSites(int p, int q) {
        int max = p;
        if (q > max) {
            max = q;
        }

        if (sites.length <= max) {
            // double size
            int[] newSites = new int[max + 1];
            int[] newWeights = new int[max + 1];

            // copy old site and weight data over new sites and weights
            int i = 0;
            while (i < sites.length) {
                newSites[i] = sites[i];
                newWeights[i] = weights[i];
                i++;
            }

            while (i < newSites.length) {
                newSites[i] = i;
                newWeights[i] = 1;
                N++;
                i++;
            }

            sites = newSites;
            weights = newWeights;
        }
    }

    public boolean union(int p, int q) {

        ensureSites(p, q);

        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) {
            return false;
        } else {
            N--;
            if (weights[rootP] < weights[rootQ]) {
                sites[rootP] = sites[rootQ];
                weights[rootQ] += weights[rootP];
            } else {
                sites[rootQ] = sites[rootP];
                weights[rootP] += weights[rootQ];
            }
           // System.out.println(Arrays.toString(sites));
           // System.out.println(Arrays.toString(weights));
            return true;
        }
    }

    public boolean connected(int p, int q) {
        if (p >= sites.length || q >= sites.length) {
            return false;
        }

        return root(p) == root(q);
    }

    public int find(int p) {
        if (p >= sites.length) {
            return -1;
        }
        return root(p);
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        DynamicUF uf = new DynamicUF(n);

        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();

            if (uf.connected(p, q)) {
                System.out.format("%d and %d are already connected.%n", p, q);
            } else {
                System.out.format("union %d and %d.%n", p, q);
                uf.union(p, q);
            }
        }

         System.out.format("size %d.%n",uf.size());
    }
}