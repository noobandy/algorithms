import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PermutationOld {

    public static void main(String[] args) {
        // reservoir sampling
        int k = Integer.parseInt(args[0]);
        String[] r = new String[k];
        int i = 0;
        for (; i < k; i++) {
            r[i] = StdIn.readString();
        }

        while (!StdIn.isEmpty()) {
            int j = StdRandom.uniform(i++);
            if (j < k) {
                r[j] = StdIn.readString();
            } else {
                StdIn.readString();
            }
        }

        for (String str : r) {
            StdOut.println(str);
        }
    }
}