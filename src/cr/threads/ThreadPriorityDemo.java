package cr.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPriorityDemo {
	public static void main(String[] args) throws InterruptedException {
		NewThread2 lo = new NewThread2(Thread.NORM_PRIORITY - 2);
		NewThread2 hi = new NewThread2(Thread.NORM_PRIORITY + 2);
		
		ExecutorService e = Executors.newCachedThreadPool();		
		e.execute(lo);
		e.execute(hi);
		
		System.out.println(lo.val);
		System.out.println(hi.val);
		
		TimeUnit.MILLISECONDS.sleep(1000);
		e.shutdown();
	}
}
