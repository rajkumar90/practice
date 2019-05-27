package cr.threads;

public class Q {
	int n;
	boolean valueSet = false;
	
	public synchronized int get() {
		while(!valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		System.out.println("Got: " + n);
		valueSet = false;
		notify();
		return n;
	}
	
	public synchronized void put(int n) {
		while(valueSet)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		this.n = n;
		System.out.println("Put: " + n);
		valueSet = true;
		notify();
	}
}
