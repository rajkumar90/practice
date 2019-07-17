package cr.threads;

public class Y implements Runnable {
	X x;
	public synchronized void bar() {
		System.out.println("bar start...");
		System.out.println("Preparing to call x.foo()...");
		x.foo();
		System.out.println("bar end...");
	}
	
	@Override
	public void run() {
		bar();
	}

}
