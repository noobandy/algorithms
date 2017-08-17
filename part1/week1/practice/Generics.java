import java.util.List;

public class Generics {

	interface Predicate<T> {
		boolean matches(T element);
	}

	public static <T> int countMatchingPredicate(T[] arr, Predicate<T> predicate) {
		int count = 0;

		for(T element : arr) {
			if(predicate.matches(element)) {
				count++;
			}
		}

		return count;
	}

	public static <T extends Comparable<T>> T maxInRange(List<T> list, int beg, int end) {
		T max = list.get(beg);
		for(int i = beg + 1; i <= end; i++) {
			int cmp = list.get(i).compareTo(max);

			if(cmp > 0) {
				max = list.get(i);
			}
		}

		return max;
	}

	

	public static void main(String[] args) {
		Predicate<String> lengthPredicate = new Predicate<String>() {
			public boolean matches(String element) {
				return element.length() > 0;
			}
		};

		String[] words = new String[] {"", "", "Anand", "Mohan"};

		System.out.println(Generics.countMatchingPredicate(words, lengthPredicate));
	}
}