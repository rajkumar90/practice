package cr.threads;

public class CurrentThreadDemo {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Current Thread: " + t);
		
		t.setName("My Thread");
		System.out.println("Current Thread: " + t);
	}
}
