package misc;

import java.util.Arrays;

public class MaxRepeat2 {
	public static String maxRepeat(int n, int d) {
		String[] arr = String.valueOf((double)n / d).split("\\.");
		System.out.println(Arrays.toString(arr));
		return "";
	}
	
	public static void main(String args[]) {
		System.out.println(maxRepeat(50, 22));
	}
}
