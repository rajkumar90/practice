package tij.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Print10to20 implements Runnable {

	CountDownLatch cdl;
	
	public Print10to20(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		for (int i = 10; i < 20; i++) {
			System.out.println(i + 1);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
