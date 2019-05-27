package practice.threads;

public class NumGenerator implements Runnable {
	int id;
	Counter counter;
	int numThreads;

	public NumGenerator(int id, int numThreads, Counter count) {
		this.id = id;
		this.numThreads = numThreads;
		this.counter = count;
	}

	public void run() {
		while (true) {
			synchronized (counter) {
				if(counter.val % numThreads != id)
					try {
						counter.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				
				System.out.println(counter.incrementAndGet());
				counter.notifyAll();
				
				if (counter.val > 100)
					break;
			}
		}
	}
}
