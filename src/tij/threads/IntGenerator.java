package tij.threads;

public abstract class IntGenerator {
	private volatile boolean isCancelled = false;
	
	public boolean isCancelled() {
		return isCancelled;
	}
	
	public void cancel() {
		isCancelled = true;
	}
	
	public abstract int next();
}
