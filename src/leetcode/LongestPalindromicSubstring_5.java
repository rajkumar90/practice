package leetcode;

import java.util.Arrays;

public class LongestPalindromicSubstring_5 {
	public String longestPalindrome(String s) {
	        if (s == null || s.length() == 0)
	            return s;
	        
	        int[] palin = new int[s.length()];
	        
	        Arrays.fill(palin, 1);
	        String res = "" + s.charAt(0);
	        for (int i = 1; i < s.length(); i++) {
	            String cur = "" + s.charAt(i);
	            // odd case
	            if (i - palin[i-1] >= 0 && s.charAt(i) == s.charAt(i - palin[i-1])) {
	                palin[i] = palin[i - 1] + 1;
	                cur = s.substring(i - palin[i] + 1, i + 1);
	            }
	                
	            // even case
	            if (i - palin[i-1] - 1 >= 0 && s.charAt(i) == s.charAt(i - palin[i-1] - 1)) {
	                palin[i] = palin[i - 1] + 2;
	                cur = s.substring(i - palin[i] + 1, i + 1);
	            }
	            
	            if (cur.length() > res.length())
	                res = cur;
	        }
	        
	        return res;
	    }
	
	public static void main(String args[]) {
		LongestPalindromicSubstring_5 l = new LongestPalindromicSubstring_5();
		System.out.println(l.longestPalindrome("babab"));
	}
}

