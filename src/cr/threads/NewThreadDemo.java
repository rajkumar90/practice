package cr.threads;

import java.util.concurrent.TimeUnit;

public class NewThreadDemo {
	public static void main(String[] args) {
		new NewThread();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Main Thread: " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Main Thread exiting");
	}
}
