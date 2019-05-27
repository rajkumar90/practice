package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFromFactory implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread() + " " + this);
			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) throws InterruptedException {
		DaemonThreadFactory d = new DaemonThreadFactory();
		for (int i = 0; i < 10; i++) {
			Thread daemon = d.newThread(new DaemonFromFactory());
			daemon.start();
		}
		System.out.println("All daemons started!");
		TimeUnit.MILLISECONDS.sleep(2000);
		
		for (int i = 0; i < 10; i++) {
			ExecutorService e = Executors.newCachedThreadPool(d);
			e.execute(new DaemonFromFactory());
		}
		System.out.println("All daemons started!");
	}
}
