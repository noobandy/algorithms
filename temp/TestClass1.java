/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class TestClass {
	
	public static void solve(int ammount, int[] parts) {
		int totalSubSets = (int) Math.pow(2.0, parts.length);
		outer:
		for(int i = 0; i < totalSubSets; i++) {
			int sum = 0;
			for(int j = 0; j < parts.length; j++) {
				if((i & (1 << j )) > 0) {
					sum += parts[j];
				}
				if(sum == ammount) {
					System.out.println("YES");
					break outer;
				}
			}
		}
	}
	
    public static void main(String args[] ) throws Exception {
       

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String firstLine = br.readLine();
            String[] tokens = firstLine.split(" ");
            int friends = Integer.parseInt(tokens[0]);
            int ammount = Integer.parseInt(tokens[1]);
            int[] parts = new int[friends];
            for(int j = 0; j < friends; j++) {
            	parts[j] = Integer.parseInt(br.readLine());
            }
            
            solve(ammount, parts);
            
        }
        

        
    }
}
