package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	private IntGenerator ig;
	private int id;
	
	public EvenChecker(IntGenerator ig, int id) {
		this.ig = ig;
		this.id = id;
	}
	
	@Override
	public void run() {
		while (!ig.isCancelled()) {
			int val = ig.next();
			if (val % 2 != 0) {
				System.out.println(val + " is not even ");
				ig.cancel();
			}
		}
	}

	public static void test(IntGenerator ig, int count) {
		ExecutorService e = Executors.newCachedThreadPool();
		for (int i = 0 ; i < count; i++) {
			e.submit(new EvenChecker(ig, i));
		}
	}
	
	public static void test(IntGenerator ig) {
		test(ig, 10);
	}

}
