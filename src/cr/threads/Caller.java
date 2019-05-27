package cr.threads;

public class Caller implements Runnable {
	CallMe target;
	String msg;
	
	Caller(CallMe target, String msg) {
		this.target = target;
		this.msg = msg;
	}
	
	@Override
	public void run() {
		synchronized (target) {
			target.call(msg);
		}		
	}

}
