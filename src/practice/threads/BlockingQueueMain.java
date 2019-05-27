package practice.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMain {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(1);
		
		Runnable producer = new Producer(bq);
		Runnable consumer = new Consumer(bq);
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.execute(producer);
		e.execute(consumer);
			
//		e.shutdownNow();
//		e.awaitTermination(1, TimeUnit.SECONDS);
	}

}
