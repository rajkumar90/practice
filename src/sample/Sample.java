package sample;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sample {

	public static boolean isPalindrome(String word) {
		  // Please write your code here.
		  if (word == null || word.isEmpty())
		    return true;
		    word = word.toLowerCase();
		  for (int i = 0, j = word.length() - 1; i > j; i++, j--) {
		    if (word.charAt(i) != word.charAt(j))
		      return false;    
		  }
		  return true;

		}

	public static void main(String[] args) throws Exception {
		System.out.println(isPalindrome("adam"));
	}

}
