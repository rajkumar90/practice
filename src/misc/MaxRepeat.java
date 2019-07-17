package misc;

import java.util.Arrays;

public class MaxRepeat {
	public static String maxRepeat(int n, int d) {
		String soFar = "";
		int[] arr = new int[10];
		Arrays.fill(arr, -1);
		
		int div = (n  * 10)/ d;
		int rem = (n * 10) % d;
		while (rem != 0 && arr[div] == -1) {
			soFar = soFar + div;
			arr[div] = soFar.length() - 1;
			
			div = (rem * 10) / d;
			rem = (rem * 10) % d;
		}
		
		return (rem == 0) ? "" : soFar.substring(arr[div]);
	}
	
	public static void main(String args[]) {
		System.out.println(maxRepeat(50, 22));
	}
}
