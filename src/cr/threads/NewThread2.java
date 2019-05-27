package cr.threads;

import java.util.concurrent.TimeUnit;

import jdk.nashorn.api.tree.YieldTree;

public class NewThread2 implements Runnable {
	private int priority;
	int val;
	
	public NewThread2(int priority) {
		this.priority = priority;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true) {
			val++;
		}
	}
}
