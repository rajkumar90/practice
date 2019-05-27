package tij.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockEvenGenerator extends IntGenerator {
	private int val = 0;
	private Lock lock = new ReentrantLock();
	
	@Override
	public int next() {
		lock.lock();
		try {
		val++;
		val++;
		return val;
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String args[]) {
		EvenChecker.test(new LockEvenGenerator());
	}
}
