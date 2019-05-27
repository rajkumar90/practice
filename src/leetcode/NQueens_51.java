package leetcode;

import java.util.ArrayList;
import java.util.List;

class NQueens_51 {
    public boolean check(List<String> board, int r, int c) {
        int n = board.size();
        // No other queen in the column
        for (int i = 0; i < n; i++)
            if (board.get(r).charAt(i) == 'Q')
                return false;
        
        // No other queen in diagonal1
        for (int i = r-1; r >=0; r--)
            for(int j = c-1; j >= 0; j--)
                if(board.get(i).charAt(j) == 'Q')
                    return false;
        
        // No other queen in diagonal2
        for (int i = r-1; r >=0; r--)
            for(int j = c+1; j <= n; j++)
                if(board.get(i).charAt(j) == 'Q')
                    return false;
        
        return true;
    }
    
    public void solveNQueensHelper(List<String> board, int r) {
    	if (r > board.size())
    		return;
    		
    	for (int i = 0; i < board.size(); i++) {
            if (check(board, r, i)) {
            	board.get(r).charAt(i) = 'Q';
            	solveNQueensHelper(board, r + 1);
            }
        }       
    }
    
    public List<String> solveNQueens(int n) {
    	List<List<String>> result = new ArrayList<List<String>>();
        String str = "";
        for (int i = 0; i < n; i++)
        	str += ".";
        
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
        	board.add(str);
        }
                
        
        result.add(board);
        return board;
    }
}