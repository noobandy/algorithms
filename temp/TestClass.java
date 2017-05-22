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
    private static Map<String, Integer> cache = new HashMap<String, Integer>();

    private static int compress(char[] chars) {
        if(chars.length <= 2) {
            return chars.length;
        }
        Integer result = cache.get(new String(chars));
        if(result != null) {
            return result;
        }

         result = chars.length;
        int s = -1;
        while((s = capture(chars, s)) >= 0) {
            char[] newChars = new char[chars.length - 1];
            for(int j = 0, k = 0; j < chars.length;j++) {
                if(j != s) {
                    newChars[k] = chars[j];
                    k++;
                }
            }
            newChars[s + 1] = chars[s];
            
            int tempResult = compress(newChars);

            if(tempResult < result) {
                result = tempResult;
            }

            if(result == 2) {
                break;
            }

            for(int j = 0, k = 0; j < chars.length;j++) {
                if(j != s + 2) {
                    newChars[k] = chars[j];
                    k++;
                }
            }

            newChars[s] = chars[s + 2];

            tempResult = compress(newChars);
            if(tempResult < result) {
                result = tempResult;
            }
            if(result == 2) {
                break;
            }
        }

        cache.put(new String(chars), result);
        
        return result;
    }
    
    private static int capture(char[] chars, int s) {
        s = s + 1;
        while(s + 2 < chars.length) {
            if(chars[s] != chars[s + 2]) {
                return s;
            } else {
                s++;
            } 
        }

        return -1;
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
        s.nextLine();
        for (int i = 0; i < N; i++) {
            System.out.println(compress(s.nextLine().toCharArray()));
        }
    }
}
