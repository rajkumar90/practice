package leetcode;
class EditDistance_72 {
    public int minDistance(String word1, String word2) {
        if ((word1 == null && word2 == null) || (word1.isEmpty() && word2.isEmpty()))
            return 0;
        
        else if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        
        else if (word2 == null || word2.isEmpty())
            return word1.length();
        
        int ed = 0;
        if (word1.charAt(0) == word2.charAt(0))
            ed = minDistance(word1.substring(1), word2.substring(1));
        else {
            int insert = minDistance(word1, word2.substring(1));
            int delete = minDistance(word1.substring(1), word2);
            int replace = minDistance(word1.substring(1), word2.substring(1));
            
            ed = 1 + Math.min(insert, Math.min(delete, replace));
        }
        
        return ed;
    }
    
    public int minDistanceDP(String word1, String word2) {
        if ((word1 == null && word2 == null) || (word1.isEmpty() && word2.isEmpty()))
            return 0;
        
        int[][] arr = new int[word1.length() + 1][word2.length() + 1];
        
        for (int i = 0; i <= word1.length(); i++)
        	for (int j = 0; j <= word2.length(); j++) 
        		arr[i][j] = Integer.MAX_VALUE;
        arr[word1.length()][word2.length()] = 0;
        
        return minDistanceDPHelper(word1, word2, 0, 0, arr);
    }
    
    public int minDistanceDPHelper(String word1, String word2, int i, int j, int[][] arr) {
    	if (arr[i][j] != Integer.MAX_VALUE)
    		return arr[i][j];
    	
    	int ed = Integer.MAX_VALUE;
    	
    	if (i >= word1.length())
    		return word2.length() - j;
    	else if (j >= word2.length())
    		return word1.length() - i;
    		
    	if (word1.charAt(i) == word2.charAt(j))
    		ed = minDistanceDPHelper(word1, word2, i + 1, j + 1, arr);
    	
    	else {
    		int insert = Integer.MAX_VALUE, delete = Integer.MAX_VALUE, replace = Integer.MAX_VALUE;
//    		if (i < word1.length())
    			delete = minDistanceDPHelper(word1, word2, i+1, j, arr);
    		
//    		if (j < word2.length())
    			insert = minDistanceDPHelper(word1, word2, i, j+1, arr);    		    		
    		
//    		if (i < word1.length() && j < word2.length())
    			replace = minDistanceDPHelper(word1, word2, i+1, j+1, arr);
    		
    		ed = 1 + Math.min(insert, Math.min(delete, replace));
    	}
    	
    	arr[i][j] = ed;
    	System.out.println(word1.substring(i) + " " + word2.substring(j) + " " +  ed);
    	return arr[i][j];
    }
    
    public static void main(String args[]) {
    	EditDistance_72 e = new EditDistance_72();
    	System.out.println(e.minDistanceDP("horse", "ros"));
    }
}