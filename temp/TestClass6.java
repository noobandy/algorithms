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
    
    private static int solution(int N, int[] p, int x1, int a, int b, int t) {
        int[] c = new int[N];
        int xl = x1;
        int result = 0;
        
        for(int i = 1; i <= t; i++) {
            int xi = xl;
            if(i > 1) {
                long axb = ((long)a * (long)xl) + (long)b;
                xi = (int) (axb % N); 
            }
            
            c[xi] += 1;
            
            if(c[xi] == p[xi]) {
                result++;
                c[xi] = 0;
            }
            
            xl = xi;
             
        }
        return result;
    }
    
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
        int Q = s.nextInt();

        for (int i = 0; i < Q; i++) {
            int N = s.nextInt();
            int[] p = new int[N];
            for(int j = 0; j < N; j++) {
                p[j] = s.nextInt();
            }
            int x1 = s.nextInt();
            int a = s.nextInt();
            int b = s.nextInt();
            int t = s.nextInt();
            
            System.out.println(solution(N, p, x1, a, b, t));
        }
    }
}
