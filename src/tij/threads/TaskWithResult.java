package tij.threads;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class TaskWithResult implements Callable<String> {

	@Override
	public String call() throws Exception {
		return String.valueOf(new SecureRandom().nextLong());
	}

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		TaskWithResult t = new TaskWithResult();
		
		for (int i = 0; i < 5; i++)
			results.add(e.submit(t));
		
		for (Future<String> f : results) {
			try {
				String val = f.get();
				System.out.println(val);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ExecutionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				e.shutdown();
			}
		}
	}
}
