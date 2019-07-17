package freshbooks;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class contains methods to flip an image represented as a 2D matrix
 * @author raj
 *
 */
public class ImageFlipper {
	
	/**
	 * This class represents the worker thread that reverses a single row in the matrix
	 * @author raj
	 *
	 */
	class WorkerThread implements Runnable {
		int[][] arr;
		int rowNum;

		WorkerThread(int[][] arr, int rowNum) {
			this.arr = arr;
			this.rowNum = rowNum;
		}

		@Override
		public void run() {
			int numCols = arr[rowNum].length;
			for (int i = 0; i < numCols / 2; i++) {
				int temp = arr[rowNum][i];
				arr[rowNum][i] = arr[rowNum][numCols - i - 1];
				arr[rowNum][numCols - i - 1] = temp;
			}
		}

	}

	/**
	 * This method spawns and starts a thread for each row in the matrix
	 * @param arr
	 * @throws InterruptedException
	 */
	public void flipImageMultiThreaded(int[][] arr) throws InterruptedException {
		int numRows = arr.length;
		ExecutorService e = Executors.newFixedThreadPool(20);
		for (int i = 0; i < numRows; i++) {
			Runnable r = new WorkerThread(arr, i);	
			e.execute(r);
		}		
		Thread.sleep(10);
	}
	
	/**
	 * This method reverses the matrix with a single thread
	 * @param arr
	 */
	public void flipImage(int[][] arr) {
		int numRows = arr.length;
		int numCols = arr[0].length;
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][numCols - j - 1];
				arr[i][numCols - j - 1] = temp;
			}
		}
	}
	

	public static void main(String args[]) throws InterruptedException {
		int arr[][] = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 } };
		ImageFlipper imageFlipper = new ImageFlipper();
		// Before flip
		System.out.println("Before flip:");
		Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));

		imageFlipper.flipImageMultiThreaded(arr);

		// After flip
		System.out.println("\nAfter flip:");
		Arrays.stream(arr).forEach(a -> System.out.println(Arrays.toString(a)));
	}
	
	/* SAMPLE OUTPUT:

Before flip:
[1, 2, 3, 4]
[1, 2, 3, 4]
[1, 2, 3, 4]
[1, 2, 3, 4]

After flip:
[4, 3, 2, 1]
[4, 3, 2, 1]
[4, 3, 2, 1]
[4, 3, 2, 1]
 
	 */
}
