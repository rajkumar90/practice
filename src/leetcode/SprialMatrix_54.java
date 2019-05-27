package leetcode;

import java.util.ArrayList;
import java.util.List;

class SprialMatrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null)
            return null;
        
        int numRows = matrix.length;
        int numCols = matrix[0].length;
        List<Integer> result = new ArrayList<Integer>();
        
        int i = 0, j = numCols - 1, k = numRows - 1, l = 0;
        while (i <= k && j >= l ) {
            // top row
            for (int p = l; p <= j; p++)
                result.add(matrix[i][p]);
            
            // right col
            for (int p = i+1; p <= k; p++)
                result.add(matrix[p][j]);
            
            // bottom row
            for (int p = j-1; p > l; p--)
                result.add(matrix[k][p]);
            
            // left col
            for (int p = k; p > i; p--)
                result.add(matrix[p][l]);
            
            i++; j--; k--; l++;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	SprialMatrix_54 s = new SprialMatrix_54();
    	int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	List<Integer> result = s.spiralOrder(matrix);
    	
    	System.out.println(result);
    }
}