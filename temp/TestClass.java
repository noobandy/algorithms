
import java.io.BufferedReader;
import java.io.InputStreamReader;



class TestClass {
    public static void main(String args[] ) throws Exception {
      

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] tokens = line.split(" ");
        int N = Integer.parseInt(tokens[0]);
        int Q = Integer.parseInt(tokens[1]);
        
        line = br.readLine();
        
        String[] nums = line.split(" ");
        
        
        for(int i = 0; i < Q; i++) {
            line = br.readLine();
            tokens = line.split(" ");
            
            if(tokens[0].equals("0")) {
                int r = Integer.parseInt(tokens[2]);
                if(nums[r - 1].equals("0")) {
                    System.out.println("EVEN");
                } else {
                    System.out.println("ODD");
                }
                
            } else {
                int x = Integer.parseInt(tokens[1]);
                if(nums[x - 1].equals("0")) {
                    nums[x - 1] = "1";
                } else {
                    nums[x - 1] = "1";
                }
            }
        }
        
        br.close();
    }
}
