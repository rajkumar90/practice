package leetcode;
class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        int table[][] = new int[numRows][numCols];
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                if (j > 0)
                    left = table[i][j-1];
                if (i > 0)
                    up = table[i-1][j];
                    
                if (left == Integer.MAX_VALUE && up == Integer.MAX_VALUE)
                	table[i][j] = grid[i][j];
                else
                	table[i][j] = Math.min(up, left) + grid[i][j];
            }
        }
        
        return table[numRows-1][numCols-1];
    }
    
    public static void main(String[] args) {
    	int[][] grid = {{1,3,1},
    			  {1,5,1},
    			  {4,2,1}};
    	MinimumPathSum_64 m = new MinimumPathSum_64();
    	System.out.println(m.minPathSum(grid));
    }
}