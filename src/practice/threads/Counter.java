package practice.threads;

public class Counter {
	int val;
	
	public Counter(int initVal) {
		this.val = initVal;
	}
	
	public int incrementAndGet() {
		return ++val;
	}
}
