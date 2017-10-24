import java.io.*;
import java.util.*;


public class TestClassPair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            char[][] A = new char[N][N];
            for(int i_A=0; i_A<N; i_A++)
            {
            	String[] arr_A = br.readLine().split(" ");
            	for(int j_A=0; j_A<arr_A.length; j_A++)
            	{
            		A[i_A][j_A] = arr_A[j_A].charAt(0);
            	}
            }

            int out_ = solution(A, K);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solution(char[][] A, int K){
        // Write your code here
        int pairs = 0;
        
        for(int i = 0; i < A.length; i++) {
            int[] paired = new int[A.length];
            
            for(int j = 0; j < A.length; j++) {
                boolean pairFound = false;
                if(paired[j] == 0) {
                    if(A[i][j] == 'T') {
                    for(int l = j + 1; l - j <= K && l < A.length; l++) {
                        if(paired[l] != 1 && A[i][l] == 'P') {
                            pairFound = true;
                            paired[l] = 1;
                            break;
                        }
                    }
                } else {
                    for(int l = j + 1; l - j <= K && l < A.length; l++) {
                        if(paired[l] != 1 && A[i][l] == 'T') {
                            pairFound = true;
                            paired[l] = 1;
                            break;
                        }
                    }
                }
                }
                
                
                if(pairFound == true) {
                    pairs++;
                }
            }
        }
        
        return pairs;
    
    }
}