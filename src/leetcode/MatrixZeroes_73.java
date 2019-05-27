package leetcode;

public class MatrixZeroes_73 {

	public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
                
        int m = matrix.length;
        int n = matrix[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }                    
            }
        }
        
        for (int i = m-1; i >= 0; i--)
            for (int j = n-1; j >= 0; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
    }
	
	public static void main(String[] args) {
		MatrixZeroes_73 m = new MatrixZeroes_73();
		int[][] arr = {{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}};
		
		m.setZeroes(arr);
		System.out.println(arr);
	}

}
