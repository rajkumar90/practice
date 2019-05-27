package tij.threads;

public class LiftOff implements Runnable {
	private static int count = 0;
	private int taskId = count++;
	private int countDown = 10; //default
	
	public LiftOff() {
		
	}
	
	public LiftOff(int countDown) {
		this.countDown = countDown;;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (countDown-- > 0) {
			String status = (countDown > 0)? countDown + "" : "LiftOff!";
			status = "#" + taskId + " " + status;
			System.out.println(status);
			Thread.yield();
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++)
			new Thread(new LiftOff()).start();
		
		System.out.println("Done!");
	}
}
