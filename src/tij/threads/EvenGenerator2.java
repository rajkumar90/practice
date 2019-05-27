package tij.threads;

public class EvenGenerator2 implements Runnable {
	int num = 1;
	
	@Override
	public synchronized void run() {
		while (true) {
			System.out.println("EvenGen: " + num);
			num += 2;
			Thread.yield();
		}
	}		
}
