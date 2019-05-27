package tij.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SampleExecutor {
	public static void main(String arrgs[]) {
		ExecutorService e = Executors.newCachedThreadPool();		
		for (int i = 0; i < 5; i++)
		e.execute(new LiftOff());
	}
}
