import java.util.*;

public class FirstNonRepeatingChar {

	public static void main(String[] args) {
		String str = args[0];
		Map<Character, Integer> chars = new HashMap<>();
		Map<Character, Integer> repeated = new HashMap<>();

		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);

			if(repeated.get(c) == null) {
				Integer index = chars.get(c);
				if(index == null) {
					chars.put(c, i);
				} else {
					chars.remove(c);
					repeated.put(c, index);
				}
			}
		}

		Integer minIndex = Integer.MAX_VALUE;
		Character firstChar = null;

		for(Map.Entry<Character, Integer> entry : chars.entrySet()) {
			if(entry.getValue() < minIndex) {
				minIndex = entry.getValue();
				firstChar = entry.getKey();
			}
		}

		System.out.format("%s is found at %d%n", firstChar, minIndex);


	}
}