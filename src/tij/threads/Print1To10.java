package tij.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Print1To10 implements Runnable {

	CountDownLatch cdl;
	
	public Print1To10(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
