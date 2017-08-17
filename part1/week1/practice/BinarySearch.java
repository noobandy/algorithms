import java.util.Comparator;
import java.util.Arrays;

public class BinarySearch {

	public static <T extends Comparable<T>> int search(T[] arr, T key) {
		int lo = 0;
		int hi = arr.length - 1;

		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = arr[mid].compareTo(key);

			if(cmp < 0) {
				lo = mid + 1;
			} else if(cmp > 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}

		return -1;
	}

	public static <T> int search(T[] arr, T key, Comparator<? super T> comparator) {
		int lo = 0;
		int hi = arr.length - 1;

		while(lo < hi) {
			int mid = lo + (hi - lo) / 2;

			int cmp = comparator.compare(arr[mid], key);

			if(cmp < 0) {
				lo = mid + 1;
			} else if (cmp > 0) {
				hi = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		Integer[] nums = new Integer[]{1,2,3,4,6};
		Integer key = 4;
		System.out.format("%d found at %d%n", key, BinarySearch.search(nums, key));

		String[] words = new String[] {"Amit", "Anand", "Pratik"};
		String word = "Anand";

		class LengthComparator implements Comparator<String> {

			public int compare(String str1, String str2) {
				return str1.length() - str2.length();
			}
		}

		LengthComparator comparator = new LengthComparator();
		
		Arrays.sort(words,comparator);


		System.out.format("%s found at %d%n", word, BinarySearch.search(words, word, comparator));

	}
}