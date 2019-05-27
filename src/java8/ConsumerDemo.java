package java8;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	public static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T e : list)
			c.accept(e);
	}
	
	public static void main(String[] args) {
		List<Integer> l = List.of(1, 2, 3);
		forEach(l, (Integer a) -> System.out.println(a));
	}
}
