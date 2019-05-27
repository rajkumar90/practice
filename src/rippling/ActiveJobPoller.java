package rippling;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Polls DB for NEW jobs
 * @author raj
 *
 */
public class ActiveJobPoller implements Runnable {
	LinkedBlockingQueue<Job> q;
	
	ActiveJobPoller(LinkedBlockingQueue<Job> q) {
		this.q = q;
	}

	@Override
	public void run() {
		// Get new jobs from DB and add to q
		Job job = new Job();
		q.offer(job);
	}
	
	
}
