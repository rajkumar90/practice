package problems;

import java.util.*;

class Solution {
	public String solution(String message, int K) {
    	String result = "";
    	if (message.length() <= K)
    		return message;
    	
    	if (message.charAt(K) == ' ')
    		result = message.substring(0, K);
    	else {
    		String temp = message.substring(0, K);
    		if (temp.contains(" "))
    			result = temp.substring(0, temp.lastIndexOf(" "));
    		else
    			result = temp.substring(0, K);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.solution("abv", 1));
    }
}