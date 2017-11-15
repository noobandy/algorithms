import java.util.*;

public class SubArraySum {

	public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int result = 0;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if(sum == k || map.get(sum - k) != null) {
            	result++;
            } 
            
            map.put(sum, i);
        }
        
        return result;
    }

    public static void main(String[] args) {
    	SubArraySum sas = new SubArraySum();
    	System.out.println(sas.subarraySum(new int[] {1,1,1}, 2));
    }
}