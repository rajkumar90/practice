package tij.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQDemo {

	public static void main(String[] args) {
		Comparator<Integer> c = (a,b) -> (b-a);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(c);
		
		pq.add(3);
		pq.add(2);
		pq.add(1);
		pq.add(5);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

}
