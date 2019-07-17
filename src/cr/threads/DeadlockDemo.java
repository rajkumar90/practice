package cr.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadlockDemo {
	public static void main(String[] args) {
		Runnable x = new X();
		Runnable y = new Y();
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.submit(x);
		e.submit(y);
	}
}
