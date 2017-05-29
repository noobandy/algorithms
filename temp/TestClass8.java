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
    
    private static int smallestPrimeFactor(int n) {
        if(n % 2 == 0) {
            return 2;
        }
 
        for(int i = 3; i * i <= n;  i = i + 2) {
            if(n % i == 0) {
                return i;
            }
        }
        
        return n;
    }
    
    private static long sumOfDevisors(int n) {
        long sd = 0;
        
        for(int i = 1; i <= n / 2; i++) {
            if(n % i == 0) {
                sd += i;
            }
        }
        
        return sd;
    }

    private static long[] part(int n) {
        long sm = n;
        long sd = 1;

        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                sd += i;

                if(sm == n) {
                    sm = i;
                }
            }
        }
        return new long[] {sm, sd};
    }
    
    private static long solution(int n) {
        long fn = 0;
        long gn = 0;

        for(int i = 2; i <= n; i++) {
            long[] part = part(i);
            fn += part[0];
            gn += part[1];
        }
        
        return (fn + gn) % n;
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
        int T = s.nextInt();

        for (int i = 0; i < T; i++) {
            int n = s.nextInt();
            System.out.println(solution(n));
        }
        
    }
}
