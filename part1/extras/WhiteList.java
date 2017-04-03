import java.util.*;
import java.io.*;

public class WhiteList {

    private static void quickSort(Integer[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(Integer[] nums, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int pivot = nums[mid];

            // partition
            int i = lo;
            int j = hi;

            while (i <= j) {
                if (nums[i] >= pivot && nums[j] <= pivot) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;

                    i++;
                    j--;
                } else {
                    if (nums[i] < pivot) {
                        i++;
                    }

                    if (nums[j] > pivot) {
                        j--;
                    }
                }

            }

            if (lo < (i - 1)) {
                quickSort(nums, lo, i - 1);
            }

            if (i < hi) {
                quickSort(nums, i, hi);
            }
        }
    }

    private static int rank(Integer[] nums, Integer num) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (num < nums[mid]) {
                hi = mid - 1;
            } else if (num > nums[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileInputStream(new File(args[0])));
        List<Integer> numList = new ArrayList<Integer>();
        while (sc.hasNext()) {
            numList.add(sc.nextInt());
        }

        sc.close();

        Integer[] nums = (Integer[]) numList.toArray(new Integer[numList.size()]);

        numList = null;

        quickSort(nums);

        sc = new Scanner(new FileInputStream(new File(args[1])));

        while (sc.hasNext()) {
            int num = sc.nextInt();
            if (rank(nums, num) == -1) {
                System.out.println(num);
            }
        }

        sc.close();

    }
}