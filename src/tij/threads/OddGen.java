package tij.threads;

import java.util.concurrent.atomic.AtomicBoolean;

public class OddGen implements Runnable {
	int val = 1;
	// false - even, true - odd
	AtomicBoolean mutex;

	OddGen(AtomicBoolean mutex) {
		this.mutex = mutex;
	}

	@Override
	public void run() {
		while (true) {			
			synchronized (mutex) {
				while(!mutex.get())
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
