package practice.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	BlockingQueue<Integer> q;
	
	public Consumer(BlockingQueue<Integer> q) {
		this.q = q;
	}
	
	@Override
	public void run() {		
		while (true) {
			try {
				int i = q.take();
				System.out.println("Consumer consumed: " + i);
				
				if (i >= 200)
					break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		
		System.out.println("Consumer done");
	}

}
