package practice.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPoolExecutor {
	BlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();
	final int NUM_THREADS = 10;
	List<Runnable> workers;
	
	public void submit(Runnable task) {
		q.add(task);
	}
	
	MyThreadPoolExecutor() {
		workers = new ArrayList<Runnable>();
		for (int i = 0; i < NUM_THREADS; i++) {
			Thread t = new Thread(new Worker(q));
			t.start();
		}
	}
	
	static class Worker implements Runnable {

		BlockingQueue<Runnable> q = new LinkedBlockingQueue<Runnable>();
		Worker(BlockingQueue<Runnable> q) {
			this.q = q;
		}
		
		@Override
		public void run() {
			while(true) {
				Runnable task;
				try {
					task = q.take();
					task.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		}
		
	}
}
