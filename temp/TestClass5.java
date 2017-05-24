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
    
    private static int password(int[][] nums, int N, int M) {
        int password = 1;
        int[] MR = new int[N];
        int[] MC = new int[M];
        
        for(int i = 0; i < N; i++) {
            int max = 1;
            MR[i] = max;
            for(int j = 1; j < M; j++) {
                if(nums[i][j] - nums[i][j - 1] == 0) {
                    max++;
                } else {
                    if(max > MR[i]) {
                        MR[i] = max;
                    }
                     max = 1;
                }
            }
            
            if(max > MR[i]) {
                MR[i] = max;
            }
        }
        
        for(int i = 0; i < M; i++) {
            int max = 1;
            MC[i] = max;
            for(int j = 1; j < N; j++) {
                if(nums[j][i] - nums[j - 1][i] == 0) {
                    max++;
                } else {
                    if(max > MC[i]) {
                        MC[i] = max;
                    }
                     max = 1;
                }
            }
            
            if(max > MC[i]) {
                MC[i] = max;
            }
        }
        Arrays.sort(MC);
        Arrays.sort(MR);
        password = MR[N - 1] * MC[M - 1];
        
        return password;
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
            int M = s.nextInt();
            
            int[][] nums = new int[N][M];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    nums[j][k] = s.nextInt();
                }
            }
            
            System.out.println(password(nums, N, M));
        }
    }
}
