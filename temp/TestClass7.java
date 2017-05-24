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
    
    private static int solution(int N, int[] boxes, int K) {
        int ways = 0;
        Arrays.sort(boxes);
        
        for(int i = 0; i < N - 1; i++) {
            int required = K - boxes[i];
            if(required <= 0 || required < boxes[i]) {
                break;
            }
            
            int requiredBox = Arrays.binarySearch(boxes, i + 1, N, required);
            
            if(requiredBox > 0) {
                ways++;
                int j = requiredBox - 1;
                while(j > i && boxes[j] == boxes[requiredBox]) {
                    j--;
                    ways++;
                }
                
                j = requiredBox + 1;
                while(j < N && boxes[j] == boxes[requiredBox]) {
                    j++;
                    ways++;
                }
            }
        }
        
        return ways;
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
            int N = s.nextInt();
            int[] boxes = new int[N];
            for(int j = 0; j < N; j++) {
                boxes[j] = s.nextInt();
            }
            
            int K = s.nextInt();
            
            System.out.println(solution(N, boxes, K));
        }
    }
}
