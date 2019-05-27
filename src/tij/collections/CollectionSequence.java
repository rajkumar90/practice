package tij.collections;

import java.util.AbstractCollection;
import java.util.Iterator;

public class CollectionSequence extends AbstractCollection<Integer>{

	public Integer[] arr = new Integer[10];
	
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < arr.length;
			}

			@Override
			public Integer next() {
				return arr[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return arr.length;
	}
	
	public static void main(String args[]) {
		CollectionSequence c = new CollectionSequence();
		Iterator<Integer> it = c.iterator();
		
		while (it.hasNext())
			System.out.println(it.next());
	}

}
