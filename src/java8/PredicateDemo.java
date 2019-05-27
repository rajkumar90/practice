package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
	public static <T> List<T> filter (List<T> list, Predicate<T> p) {
		List<T> results = new ArrayList<T>();
		for (T element : list) {
			if (p.test(element))
				results.add(element);
		}
		return results;
	}
	
	public static void main(String args[]) {
		List<Integer> l = List.of(1,2,3, 10, 20, 30);
		
		l = filter(l, (Integer a) -> a > 5);
		System.out.println(l);
	}
}
