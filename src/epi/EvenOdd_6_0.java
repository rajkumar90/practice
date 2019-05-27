package epi;

import java.util.Arrays;

public class EvenOdd_6_0 {
	public void evenOdd(int[] arr) {
		if (arr == null)
			return;
		int e = -1, o = arr.length;
		for (int i = 0; i < arr.length; i ++) {
			if (arr[i] % 2 == 0) {
				int temp = arr[i];
				arr[i] = arr[++e];
				arr[e] = temp;
			}
		}
	}
	
	public void evenOdd2(int[] arr) {
		if (arr == null)
			return;
		int e = 0, o = arr.length-1;
		while (e < o) {
			if (arr[e] % 2 == 0) {
				++e;
			} else {
				int temp = arr[e];
				arr[e] = arr[o];
				arr[o--] = temp;
			}
		}
	}
	
	public static void main(String args[]) {
		EvenOdd_6_0 obj = new EvenOdd_6_0();
		int[] arr = {1,2,3,4,5};
		obj.evenOdd2(arr);
		System.out.println(Arrays.toString(arr));
	}
}
