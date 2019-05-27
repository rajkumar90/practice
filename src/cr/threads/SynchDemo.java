package cr.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchDemo {

	public static void main(String[] args) {
		ExecutorService e = Executors.newCachedThreadPool();
		
		CallMe target = new CallMe();
		e.execute(new Caller(target , "Hello"));
		e.execute(new Caller(target , "Synchronized"));
		e.execute(new Caller(target , "World"));
	}

}
