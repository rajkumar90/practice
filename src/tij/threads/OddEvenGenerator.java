package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class OddEvenGenerator {
	public static void main(String[] args) throws InterruptedException {
		Runnable even = new Thread(new EvenGenerator2());
		Runnable odd = new Thread(new OddGenerator());
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(odd);
		e.execute(even);
		
		TimeUnit.MILLISECONDS.sleep(1000);
	}
}
