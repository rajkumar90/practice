package leetcode;

public class Leetcode_10 {
	private boolean result[][] = new boolean[100][100];
	
	public boolean isMatchRecursive(String s, String p) {
		if (s.equals(p))
			return true;
		
		boolean isInitialMatch = !s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		
		if (p.length() > 1 && p.charAt(1) == '*') {			
			return (isInitialMatch && isMatchRecursive(s.substring(1), p)) ||
					(isMatchRecursive(s, p.substring(2)));
		} else {
			return isInitialMatch && isMatchRecursive(s.substring(1), p.substring(1));
		}
	}
	
	public boolean isMatchTopDown(String s, String p) {
		if (s.equals(p))
			return true;
		
		boolean isInitialMatch = !s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
		
		if (p.length() > 1 && p.charAt(1) == '*') {			
			return (isInitialMatch && isMatchRecursive(s.substring(1), p)) ||
					(isMatchRecursive(s, p.substring(2)));
		} else {
			return isInitialMatch && isMatchRecursive(s.substring(1), p.substring(1));
		}
	}
	
	public static void main(String args[]) {
		Leetcode_10 l = new Leetcode_10();
		String str = "aaaaab";
		String pattern = "a*b";
		boolean match = l.isMatchTopDown(str, pattern);
		System.out.println(match);
	}

}
