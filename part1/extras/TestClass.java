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
            int compartment = (N / 12) + 1;
            int seat = (12 - ((compartment * 12) - N));
            int oposite = 12 * (compartment - 1) + (12 - seat + 1) % 12;
            
            if(oposite % 6 == 0 || oposite % 6 == 1) {
                System.out.format("%d %s%n", oposite, "WS");  
            } else if(oposite % 3 == 0 || oposite % 3 == 1) {
                System.out.format("%d %s%n", oposite, "AS");
            } else {
                System.out.format("%d %s%n", oposite, "MS");
            }
        }
    }
}
