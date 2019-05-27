package tij.threads;

public class SynchronizedEvenGenerator extends IntGenerator {
	private int val = 0;
	
	@Override
	public synchronized int next() {
		// TODO Auto-generated method stub
		val++;
		val++;
		System.out.println(val);
		return val;
	}
	
	public static void main(String args[]) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}
}
