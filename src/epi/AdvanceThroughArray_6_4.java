package epi;

public class AdvanceThroughArray_6_4 {

	public boolean isFeasible(int[] arr) {
		if (arr == null || arr.length == 0)
			return true;
		
		int maxIndex = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxIndex >= arr.length-1)
				return true;
			
			if (i <= maxIndex)
				maxIndex = Math.max(maxIndex, arr[i] + maxIndex);			
		}		
		return false;
	}
	
	public static void main(String[] args) {
		AdvanceThroughArray_6_4 a = new AdvanceThroughArray_6_4();
		int[] arr = {1,2,0,3};
		System.out.println(a.isFeasible(arr));
	}

}
