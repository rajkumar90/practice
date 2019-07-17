package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak_2_140 {

	public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
    
    public List<String> wordBreakHelperRecursive(String s, List<String> wordDict, int index) {
    	List<String> result = new ArrayList<String>();
        if(index == s.length()) {
            result.add("");
        }
        
        for (int i = index+1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i))) {
            	List<String> strList = wordBreakHelperRecursive(s, wordDict, i);
            	for (int j = 0; j < strList.size(); j++) {
            		result.add((s.substring(index, i) + " " + strList.get(j)).trim());
            	}
            }
        }
        return result;
    }
    
    HashMap<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    
    public List<String> wordBreakHelper(String s, List<String> wordDict, int index) {
    	List<String> result = new ArrayList<String>();
        if(index == s.length()) {
            result.add("");
            map.put(index, result);
        }        
        
        for (int i = index+1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(index, i))) {
            	List<String> strList = null;
            	if (map.containsKey(i))            	
            		strList = map.get(i);
            	else
            		strList = wordBreakHelper(s, wordDict, i);
            	for (int j = 0; j < strList.size(); j++) {
            		result.add((s.substring(index, i) + " " + strList.get(j)).trim());
            	}
            }
        }
        map.put(index, result);
        return result;
    }
    
	public static void main(String[] args) {
		WordBreak_2_140 w = new WordBreak_2_140();
		String s = "catsanddog";
		List<String> wordDict = List.of("cat", "cats", "and", "sand", "dog");
		System.out.println(w.wordBreak(s, wordDict));
	}

}
