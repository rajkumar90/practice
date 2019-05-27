package tij.threads;

public class OddGenerator implements Runnable {
	int num = 0;
	
	@Override
	public synchronized void run() {
		while (true) {
			System.out.println("OddGen: " + num);
			num += 2;
			Thread.yield();
		}
	}		
}
