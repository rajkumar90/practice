package leetcode;

public class InterleaveString_97 {

	public boolean isInterleaveRecursive(String s1, String s2, String s3) {
        if (s3 == null) {
            return (s1 == null && s2 == null && s3 == null);
        }
        
        if (s3.isEmpty())
        	return s1.isEmpty() && s2.isEmpty() && s3.isEmpty();
        
        boolean result = false;
        if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0))
            result = isInterleaveRecursive(s1.substring(1), s2, s3.substring(1));
        
        if (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0))
            result = result || isInterleaveRecursive(s1, s2.substring(1), s3.substring(1));
        
        System.out.println(s1 + " " + s2 + " " + s3);
        return result;
    }
	
	public boolean isInterleave(String s1, String s2, String s3) {
		boolean result = false;
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleaveString_97 obj = new InterleaveString_97();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		boolean result = obj.isInterleaveRecursive(s1, s2, s3);
		System.out.println(result);
	}

}
