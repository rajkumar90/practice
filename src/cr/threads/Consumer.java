package cr.threads;

public class Consumer implements Runnable {
	
	Q q;
	
	Consumer(Q q) {
		this.q = q;
	}
	
	@Override
	public void run() {		
		while(true) {
			q.get();
		}
	}

}
