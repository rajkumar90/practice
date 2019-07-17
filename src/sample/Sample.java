package sample;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Sample {

	class TimeValuePair {
		int timestamp;
		String value;

		TimeValuePair(int timestamp, String value) {
			this.timestamp = timestamp;
			this.value = value;
		}
	}

	public static boolean isPalindrome(String word) {
		// Please write your code here.
		if (word == null || word.isEmpty())
			return true;
		word = word.toLowerCase();
		for (int i = 0, j = word.length() - 1; i > j; i++, j--) {
			if (word.charAt(i) != word.charAt(j))
				return false;
		}
		return true;

	}

	public static void main(String[] args) throws Exception {
		List<String> l = List.of("abc", "abc", "cde");
		Map<String, Long> m = l.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		TreeMap<String, Long> tm = new TreeMap<String, Long>(new Com);
		tm.putAll(m);
		System.out.println(tm.firstKey());
	}

}
