package epi;

import java.util.Arrays;

public class RotateMatrix_2_18 {
	public void rotateMatrix(int[][] arr) {
		if (arr == null || arr.length == 0)
			return;
		
		// n * n matrix - numRows == numCols
		int numRows = arr.length, numCols = numRows;
		for (int r1 = 0, r2 = numRows - 1, c1 = 0, c2 = numCols - 1; r1 < r2 && c1 < c2; r1++, r2--, c1++, c2--) {
			for (int i = c1; i < c2; i++) {
				int temp = arr[r1][i];
				arr[r1][i] = arr[r2-i][c1];
				arr[r2-i][c1] = arr[r2][c2-i];
				arr[r2][c2-i] = arr[i][c2];
				arr[i][c2] = temp;
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[][] arr = { {1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
		};
		RotateMatrix_2_18 obj = new RotateMatrix_2_18();
		obj.rotateMatrix(arr);
		System.out.println(Arrays.deepToString(arr).replace("],", "],\n"));
	}

}
