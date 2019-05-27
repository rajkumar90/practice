package epi;

import java.util.LinkedList;
import java.util.List;

public class Increment_6_2 {
	public static void main(String[] args) {
		Increment_6_2 obj = new Increment_6_2();
		int[] arr = {-7,9,9};
		List<Integer> result = obj.plusOne(arr);
		System.out.println(result);
	}

	private List<Integer> plusOne(int[] arr) {
		List<Integer> result = new LinkedList<Integer>();
		if (arr == null)
			return result;
		
		int carry = 1, sum = 0;
		for (int i = arr.length-1; i >= 0; i--) {
			sum = (arr[i] + carry) % 10;
			carry = (arr[i] + carry) / 10;
			result.add(0, sum);
		}
		return result;
	}
}
