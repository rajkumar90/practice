package cr.threads;

import java.util.concurrent.TimeUnit;

public class A {
	public synchronized void foo(B b) {
		System.out.println("A.foo()");
		
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Preparing to call B.bar()");	
		b.bar(this);
	}	
}
