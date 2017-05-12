/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
//import for Scanner and other utility  classes
import java.util.*;
import java.math.*;


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
            int M = s.nextInt();
            BigDecimal divisor = BigDecimal.ONE;
            for(int j = 0; j < M; j++) {
                divisor = divisor.multiply(BigDecimal.TEN);
            }
            System.out.println(divisor);

            boolean done = false;
            int numCount = 0;
            String nums = "";
            BigDecimal k = BigDecimal.ZERO;
            BigDecimal fact = BigDecimal.ZERO;
            while(!done) {
            	System.out.println(k);
                if(k.equals(BigDecimal.ZERO) || k.equals(BigDecimal.ONE)) {
                    fact = BigDecimal.ONE;
                } else {
                    fact = fact.multiply(k);
                }
                System.out.println(fact);
                
                if(fact.remainder(divisor).equals(BigDecimal.ZERO)) {
                    if(!fact.remainder(divisor.multiply(BigDecimal.TEN)).equals(BigDecimal.ZERO)) {
                        numCount++;
                        nums = nums + " " + k;
                    } else {
                        done = true;
                    }
                }
                System.out.println(numCount);
                System.out.println(numCount);
                
                k = k.add(BigDecimal.ONE);
            }
            
            System.out.println(numCount);
            System.out.println(nums.trim());
        }
        
    }
}
