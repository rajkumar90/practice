package leetcode;
class DistinctSubsequences_115 {
    
    public int numDistinct(String s, String t) {
        if (s == null || t == null)
            return 0;
        
        if (t.equals(""))
            return 1;
        
        if (s.equals(""))
            return 0;
                
        int numRows = s.length() + 1;
        int numCols = t.length() + 1;
        
        int[][] arr = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++)
            for (int j = 0; j < numCols; j++)
                arr[i][j] = -1;
        
        for (int i = 0; i < numCols; i++)
            arr[numRows-1][i] = 0;
        
        for (int i = 0; i < numRows; i++)
            arr[i][numCols - 1] = 1;                
        
        return numDistinctHelper(s, t, 0, 0, arr);
    }
    
    public int numDistinctHelper (String s, String t, int i, int j, int[][] arr) {  
    	if (j >= t.length())
            return 1;
    	
        if (i >= s.length())
            return 0;                
        
        if (arr[i][j] > 0)
            return arr[i][j];
        
        arr[i][j] = 0;
        
        if (s.charAt(i) == t.charAt(j)) {
                arr[i][j] = numDistinctHelper(s, t, i+1, j+1, arr);
        }
        
        arr[i][j] += numDistinctHelper(s, t, i+1, j, arr);        
        return arr[i][j];
    }
    
    public static void main(String args[]) {
    	DistinctSubsequences_115 d = new DistinctSubsequences_115();
    	System.out.println(d.numDistinct("bagbag", "bag"));
    	
    }
}