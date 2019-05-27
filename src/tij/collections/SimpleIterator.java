package tij.collections;

import java.util.List;
import java.util.ListIterator;

public class SimpleIterator {
	public static void main(String[] args) {
		List<Integer> list = List.of(1,2,3);
		ListIterator<Integer> it = list.listIterator();
		
//		while(it.hasNext())
//			System.out.println(it.next());
		
		while(it.hasPrevious())
			System.out.println(it.previous());
		
	}
}
