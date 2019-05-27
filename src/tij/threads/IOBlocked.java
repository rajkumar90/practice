package tij.threads;

import java.io.IOException;
import java.io.InputStream;

public class IOBlocked implements Runnable {

	InputStream is;
	
	public IOBlocked(InputStream is) {
		this.is = is;
	}
	
	@Override
	public void run() {
		System.out.println("Waiting to read...");
		try {
			is.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Exting IOBlocked.run()");
	}

}
