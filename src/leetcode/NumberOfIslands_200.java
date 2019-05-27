package leetcode;
class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        boolean visited[][] = new boolean[numRows][numCols];

        int numIslands = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    markIslands(grid, i, j, visited);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }
    
    public void markIslands(char[][] grid, int i, int j, boolean[][] visited) {
        int[] x = {0, 1, 0, -1};
        int[] y = {1, 0, -1, 0};

        visited[i][j] = true;
        for (int xi = 0; xi < x.length; xi++) {
        	int nexti = i + x[xi];
        	int nextj = j + y[xi];
            if (nexti >= 0 && nexti < grid.length && nextj >= 0 && nextj < grid[0].length && grid[nexti][nextj] == '1' && !visited[nexti][nextj]) {
                markIslands(grid, i + x[xi], j + y[xi], visited);
            }
        }
    }
    
    public static void main(String args[]) {
    	NumberOfIslands_200 n = new NumberOfIslands_200();
    	char[][] grid = {
    			{'1','1','1','1','0'},
    			{'1','1','0','1','0'},
    			{'1','1','0','0','0'},
    			{'0','0','0','0','0'}
    	};
    	
    	System.out.println(n.numIslands(grid));
    }
}