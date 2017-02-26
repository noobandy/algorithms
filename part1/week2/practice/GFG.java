import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    private static boolean match(String str, String sub, int start) {
        int i = start;
        int j = 0;
        while((i <  str.length()) && (j < sub.length()) && (str.charAt(i) == sub.charAt(j))) {
            i++;
            j++;
        }

        if(j == sub.length()) {
            return true;
        } else {
            return false;
        }
    }
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        sc.nextLine();
		for(int i = 0; i < T; i++) {
		    String sub = sc.nextLine();
		    String str = sc.nextLine();
            int lastMatch = -1;
		    for(int j = 0; j < str.length(); j++) {

                if(match(str, sub, j)) {
                    lastMatch = j;
                }
            }

            if(lastMatch != - 1) {
                System.out.println(lastMatch + 1);
            } else {
                System.out.println(lastMatch);
            }
            
		    
		}
	}
}