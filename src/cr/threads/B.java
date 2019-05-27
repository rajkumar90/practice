package cr.threads;

import java.util.concurrent.TimeUnit;

public class B {
	public synchronized void bar(A a) {
		System.out.println("B.bar()");
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Preparing to call A.foo()");
		a.foo(this);
	}
	
}
