import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    private static String reduce(String expr) {
        StringBuilder sb = new StringBuilder();
        boolean switchSign = false;
        
        for(int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            
            if(c == '(') {
                switchSign = true;
            } else if(c == ')') {
                switchSign = false;
            } else {
                if(switchSign) {
                    if(c == '+') {
                        c = '-';
                    } else if(c == '-') {
                        c = '+';
                    } else {
                        // do nothing
                    }
                }
                
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		s.nextLine();
		for(int i = 0; i < T; i++) {
		    String expr1 = s.nextLine();
		    String expr2 = s.nextLine();
		   
		    
		    if(reduce(expr1).equals(reduce(expr2))) {
		        System.out.println("YES");
		    } else {
		         System.out.println("NO");
		    }
		}
	}
}