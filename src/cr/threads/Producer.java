package cr.threads;

public class Producer implements Runnable {

	Q q;
	
	Producer(Q q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(true)
			q.put(i++);
	}
}
