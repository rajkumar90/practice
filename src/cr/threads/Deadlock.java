package cr.threads;

public class Deadlock implements Runnable {
	A a = new A();
	B b = new B();
	
	Deadlock() {
		Thread t = new Thread(this, "Racing Thread");
		t.start();
		a.foo(b);
		System.out.println("Back in main thread");
	}
	
	public static void main(String[] args) {
		new Deadlock();
	}

	@Override
	public void run() {
		b.bar(a);
		System.out.println("Back in racing thread");
	}

}
