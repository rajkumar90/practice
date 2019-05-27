package practice.threads;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	BlockingQueue<Integer> q;
	
	public Producer(BlockingQueue<Integer> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i <= 200; i++)
			try {				
				q.put(i);
				System.out.println("Producer produced: " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("Producer done");
	}

}
