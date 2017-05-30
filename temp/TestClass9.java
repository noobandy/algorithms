/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;


class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int[] times = new int[32];
            for(int j = 0; j < N; j++) {
                int num = s.nextInt();
                for(int k = 0; k < 32; k++) {
                    int mask = 1 << k;
                    if((num & mask) == mask) {
                        times[k]++;
                    }
                }
                
            }
            
            int max = 0;
            int maxIndex = 0;
            for(int j = 0; j < 32; j++) {
                if(times[j] > max) {
                    max = times[j];
                    maxIndex = j;
                }
            }
            System.out.println(maxIndex);
        }
    }
}
