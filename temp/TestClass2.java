/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestClass {
	
	public static String solve(int amount, int[] parts) {
	    int start = 0;
	    int end = 0;
	    int sum = 0;
	    
	    for(int i = 0; i < parts.length; i++) {
	    	end = i;
	    	sum = sum + parts[end];

	        if(sum == amount) {
	           return "YES";
	        }
	        
	        if(sum > amount) {
	            while(sum > amount) {
	                sum = sum - parts[start];
	                if(sum == amount) {
	                    return "YES";
	                }
	                
	                start = start + 1;
	            }
	        }
	    }
	    return "NO";
	}
	
    public static void main(String args[] ) throws Exception {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String firstLine = br.readLine();
            String[] tokens = firstLine.split(" ");
            int friends = Integer.parseInt(tokens[0]);
            int amount = Integer.parseInt(tokens[1]);
            int[] parts = new int[friends];
            for(int j = 0; j < friends; j++) {
            	parts[j] = Integer.parseInt(br.readLine());
            }
            
            System.out.println(solve(amount, parts));
            
        }
        

        
    }
}
