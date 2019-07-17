package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class OddEvenGenerator {
	public static void main(String[] args) {
		AtomicBoolean mutex = new AtomicBoolean(false);
		
		Runnable odd = new OddGen(mutex);
		Runnable even = new EvenGen(mutex);
		
		ExecutorService e = Executors.newFixedThreadPool(2);
		e.execute(even);
		e.execute(odd);
	}
}
