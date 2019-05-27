package leetcode;
class PalindromePartitioning_132 {
    public boolean isPalin(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
    
    public int minCut(String s) {
      return 0;  
    }
    
    public static void main(String args[]) {
    	PalindromePartitioning_132 p = new PalindromePartitioning_132();
    	System.out.println(p.isPalin("aba"));
    }
}