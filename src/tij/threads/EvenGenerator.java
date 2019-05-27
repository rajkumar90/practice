package tij.threads;

public class EvenGenerator extends IntGenerator {
	private int val = 0;
	
	@Override
	public int next() {
		// TODO Auto-generated method stub
		val++;
		val++;
		return val;
	}
	
	public static void main(String args[]) {
		EvenChecker.test(new EvenGenerator());
	}
}
