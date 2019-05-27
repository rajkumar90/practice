package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		Runnable r = new ExceptionThread();
		
		ExecutorService e = Executors.newFixedThreadPool(1, new ExceptionHandlerThreadFactory());
		try {
		e.execute(r);
		} catch (Exception ex) {
			System.out.println("Caught exception: " + ex);
		}
	}

}
