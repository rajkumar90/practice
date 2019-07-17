package misc;

/*
 * https://leetcode.com/discuss/interview-question/306859/google-phone-screen-split-strings-to-form-a-palindrome
 */
public class PalindromeSplit {
	public boolean checkPalindromeSplit(String a, String b) {
		boolean r1 = true, r2 = true;
		int i = 0, j = a.length()-1;
		for (; i <= j; i++, j--) {
			if (r1 && a.charAt(i) != b.charAt(j)) {
				r1 = isPalindrome(b.substring(i, j+1));
			}
			if (r2 && b.charAt(i) != a.charAt(j)) {
				r2 = isPalindrome(a.substring(i, j+1));
			}
		}
		
		return r1 || r2;
	}
	
	private boolean isPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromeSplit p = new PalindromeSplit();
		String s1 = "aba", s2 = "xyz";
		System.out.println(p.checkPalindromeSplit(s1, s2));
	}

}
