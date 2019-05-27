package cr.threads;

public class MultiThreadDemo {
	public static void main(String[] args) {
		NewThread t1 = new NewThread("t1");
		NewThread t2 = new NewThread("t2");
		NewThread t3 = new NewThread("t3");
		
		System.out.println(t1.t.isAlive());
		System.out.println(t2.t.isAlive());
		System.out.println(t3.t.isAlive());
		
		try {
			t1.t.join();
			t2.t.join();
			t3.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(t1.t.isAlive());
		System.out.println(t2.t.isAlive());
		System.out.println(t3.t.isAlive());
	}
}
