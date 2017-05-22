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
    
    private static int solve(int num) {
        int bases = 0;
        int sum = 0;
        
        for(int base = 2; base < num; base++) {
            bases++;
            int numCopy = num;
            while(numCopy >= base) {
                sum = sum + numCopy % base;
                numCopy = numCopy / base;
            }
            
            sum = sum + numCopy;
        }
        
        int hcf = hcf(sum, bases);
        return bases / hcf;
    }
    
    private static final int hcf(int a, int b) {
        if(b != 0) {
            return hcf(b, a % b);
        } else {
            return a;
        }
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
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.println(solve(s.nextInt()));
        }
    }
}
