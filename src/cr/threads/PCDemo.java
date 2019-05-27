package cr.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PCDemo {
	public static void main(String[] args) {
		Q q = new Q();
		Producer p = new Producer(q);
		Producer p2 = new Producer(q);
		Consumer c = new Consumer(q);
		Consumer c2 = new Consumer(q);
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(p);
		e.execute(c);
		
		try {
			TimeUnit.MILLISECONDS.sleep(2000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		e.shutdownNow();
	}
}
