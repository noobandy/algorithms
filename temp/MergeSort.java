import java.util.*;

class MergeSort {
    
    public static void sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    
    public static void mergeSort(int[] nums, int start, int end) {
        if(end - start >= 1) {
            int mid = start + (end - start) / 2;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }
    }
    
    public static void merge(int[] nums, int start, int mid, int end) {
        if(!(nums[mid] <= nums[mid + 1])) {
            int[] temp = new int[end - start + 1];
            int k = 0;
            int i = start, j = mid + 1;
            for(; i <= mid && j <= end;) {
                
                if(nums[i] <= nums[j]) {
                    temp[k++] = nums[i];
                    i++;
                } else {
                    temp[k++] = nums[j];
                    j++;
                }
            }
            
            while(i <= mid) {
                temp[k++] = nums[i++];
            }
            
            while(j <= end) {
                temp[k++] = nums[j++];
            }
            
            // copy back
            for(k = 0 ; k < temp.length; k++) {
                nums[start + k] = temp[k];
            }
        }
    }
    
    public static int binarySearch(int[] nums, int key) {
        int rank = -1;
        
        int start = 0, end = nums.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] < key) {
                start = mid + 1;
            } else if(nums[mid] > key) {
                end = mid - 1;
            } else {
                rank = mid;
                break;
            }
        }
        
        return rank;
    }
    
    public static void main(String args[] ) throws Exception {
       
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = s.nextInt();
        }
        
        sort(nums);

        // System.out.println(Arrays.toString(nums));
        
        int Q = s.nextInt();
        
        for(int i = 0; i < Q; i++) {
            int key = s.nextInt();
            
            int rank = binarySearch(nums, key);
            //System.out.format("rank of %d is %d%n", key, rank);
            if(rank >= 0) {
                System.out.format("%d%n", rank + 1);
            }
            
        }
    }
}
