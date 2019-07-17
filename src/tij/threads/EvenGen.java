package tij.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class EvenGen implements Runnable {
	int val = 0;
	// false - even, true - odd
	AtomicBoolean mutex;

	EvenGen(AtomicBoolean mutex) {
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while (true) {			
			synchronized (mutex) {
				while(mutex.get())
					try {
						mutex.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println(val);
				val += 2;
				mutex.set(mutex.get() ^ true);
				mutex.notifyAll();
			}
		}
	}
}
