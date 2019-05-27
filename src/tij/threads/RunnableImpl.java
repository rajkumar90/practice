package tij.threads;

public class RunnableImpl implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}
	
	public static void main(String[] args) {
		Runnable r = new RunnableImpl();
		Thread t = new Thread(r);
		t.start();
		
		Runnable r2 = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		};
	}
}
