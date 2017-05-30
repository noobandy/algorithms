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
    
    private static int[][] matrix(int[] nums) {
        int[][] matrix = new int[nums.length][nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = nums[i] ^ nums[j];
            }
        }
        
        return matrix;
    }
    
    private static long summation(int[][] matrix, int x1, int y1, int x2, int y2) {
        long sum = 0;
        
        for(int i = x1 - 1; i < x2; i++) {
            for(int j = y1 - 1; j < y2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    
     private static long summation(int[] nums, int x1, int y1, int x2, int y2) {
        long sum = 0;
        
        for(int i = x1 - 1; i < x2; i++) {
            for(int j = y1 - 1; j < y2; j++) {
                sum += (nums[i] ^ nums[j]);
            }
        }
        return sum;
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
        int[] nums = new int[N]; 
        for (int i = 0; i < N; i++) {
            nums[i] = s.nextInt();
        }
        
        int[][] matrix = matrix(nums);
        
        nums = null;
        
        int Q = s.nextInt();
        
        for(int i = 0; i < Q; i++){
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            
            System.out.println(summation(matrix, x1, y1, x2, y2));
        }
        
    }
}
