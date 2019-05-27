package rippling;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class JobExecutor {
	
	LinkedBlockingQueue<Job> q = new LinkedBlockingQueue<Job>();
	ExecutorService e;
	
	// Initialized at startup
	public JobExecutor() {		
		Runnable poller = new ActiveJobPoller(q);
		
		// Could be done with executor service as well
		new Thread(poller).start();
		
		e = Executors.newCachedThreadPool();
	}
	
	public int
	
	
}
