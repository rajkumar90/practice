package cr.threads;

public class X implements Runnable {
	Y y;
	public synchronized void foo() {
		System.out.println("foo start...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Preparing to call y.bar()...");
		y.bar();
		System.out.println("foo end...");
	}
	@Override
	public void run() {
		foo();
	}

}
