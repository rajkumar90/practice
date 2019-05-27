package practice.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NumGeneratorMain {
	public static void main(String[] args) {
		int numThreads = 3;
		Runnable[] tasks = new Runnable[numThreads];
			
		Counter counter = new Counter(0);
		ExecutorService e = Executors.newFixedThreadPool(numThreads);
		for (int i = 0; i < numThreads; i++) {
			tasks[i] = new NumGenerator(i, numThreads, counter);
			e.execute(tasks[i]);
		}
		
		try {
			TimeUnit.MILLISECONDS.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		e.shutdownNow();
	}
}
