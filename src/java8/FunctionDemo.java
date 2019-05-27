package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
	
	public static <T, R> List<R> map(List<T> l, Function<T, R> f) {
		List<R> result = new ArrayList<R>();
		for (T e : l) {
			result.add(f.apply(e));
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		List<String> l = List.of("I", "am", "game");
		List<Integer> len = map(l, (String a) -> a.length());
		System.out.println(len);
	}
}
