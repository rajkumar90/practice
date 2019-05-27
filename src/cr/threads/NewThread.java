package cr.threads;

import java.util.concurrent.TimeUnit;

public class NewThread implements Runnable {
	String name;
	Thread t;
	
	NewThread() {
		t = new Thread(this, "Child Thread");
		System.out.println("Child Thread: " + t);
		t.start();
	}
	
	NewThread(String name) {
		this.name = name;
		t = new Thread(this, name);
		System.out.println(t);
		t.start();
	}
	
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(name + " " + i);
				TimeUnit.MILLISECONDS.sleep(500);
			}
		} catch(InterruptedException ie) {
			System.out.println("Child Thread interrupted");
		}
		
		System.out.println("Exiting Child Thread");
	}

}
