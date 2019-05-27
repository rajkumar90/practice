package tij.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockedMutex {
	private Lock lock = new ReentrantLock();
	
	public BlockedMutex() {
		lock.lock();
	}
	
	public void f() {
		try {
			lock.lockInterruptibly();
			System.out.println("Lock acquired in f");
		} catch (InterruptedException e) {
			System.out.println("Interrupted from lock acquisition in f()");
		}
	}
}
