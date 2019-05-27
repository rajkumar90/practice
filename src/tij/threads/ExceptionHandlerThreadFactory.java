package tij.threads;

import java.util.concurrent.ThreadFactory;

public class ExceptionHandlerThreadFactory implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		return t;
	}

}
