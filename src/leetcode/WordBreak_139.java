package leetcode;

import java.util.Arrays;
import java.util.List;

class WordBreak_139 {
    public boolean wordBreakHelper(String s, List<String> wordDict, int start, int[] mem) {
        
    	if (s == null || s.isEmpty() || start == s.length())
            return true;             
    	
    	if (mem[start] != -1)
    		return mem[start] == 1;
    	
        for (int i = start + 1; i <= s.length(); i++) {
        		if (wordDict.contains(s.substring(start, i)) && wordBreakHelper(s, wordDict, i, mem)) {
        			mem[start] = 1;
        			return true;
        		}
        }
        
        mem[start] = 0;
        return mem[start] == 1;
            
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
    	if (s == null || s.isEmpty())
            return true;                
        
        int[] mem = new int[s.length()];
        Arrays.fill(mem, -1);
        return wordBreakHelper(s, wordDict, 0, mem);
    }
    
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        if (s == null || s.isEmpty() || wordDict.contains(s))
            return true;
        
        for (int i = 0; i < s.length()-1; i++) {
            if (wordDict.contains(s.substring(0, i+1)) && wordBreak(s.substring(i+1), wordDict))
                return true;
        }
                
        return false;
            
    }
    
    public static void main(String[] args) {
    	WordBreak_139 w = new WordBreak_139();
    	List<String> wordDict = List.of("leet", "bode");
    	String word = "leetbode";
    	System.out.println(w.wordBreak(word, wordDict));
    }
}