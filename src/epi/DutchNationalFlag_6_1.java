package epi;

import java.util.Arrays;

public class DutchNationalFlag_6_1 {

	public void sort(int[] arr) {
		int low = 0, mid = 0, high = arr.length-1;
		while (low < high && mid < high) {
			System.out.println(Arrays.toString(arr));
			if (arr[low] == 0)
				low++;
			else if (arr[low] == 1) {
				// swap arr[low] and arr[mid]
				int temp = arr[low];
				arr[low] = arr[mid];
				arr[mid++] = temp;
			} else if (arr[low] == 2) {
				// swap arr[low] and arr[high]
				int temp = arr[low];
				arr[low] = arr[high];
				arr[high--] = temp;
			} 
//			else if (arr[mid] == 2) {
//				// swap arr[mid] and arr[high]
//				int temp = arr[mid];
//				arr[mid] = arr[high];
//				arr[high--] = temp;
//			}
		}
	}
	
	public static void main(String[] args) {
		DutchNationalFlag_6_1 obj = new DutchNationalFlag_6_1();
		int arr[] = {1,2,1,1,0,2,1,0,1};
		obj.sort(arr);
		System.out.println(Arrays.toString(arr));		
	}

}
