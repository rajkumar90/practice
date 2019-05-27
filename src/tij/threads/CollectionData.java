package tij.threads;

import java.util.ArrayList;

public class CollectionData<T> extends ArrayList<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CollectionData(Generator<T> gen, int qty) {
		for (int i = 0; i < qty; i++)
			add(gen.next());
	}
	
	public static <T> CollectionData<T> list(Generator<T> gen, int qty) {
		return new CollectionData<T>(gen, qty);
	}
}
