package article.codility;

import java.util.HashMap;

class Solution {
    public int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
    	int mod = 1000000007;
        if (A == null || A.length == 0 || K + L > A.length)
            return -1;
        
        int[] kSum = new int[A.length];
        int[] lSum = new int[A.length];
        
        int curSum = 0;
        for (int i = A.length - 1; i > A.length - 1 - K; i--)
        	curSum = (curSum + A[i]) % mod;
        kSum[A.length - K] = curSum;
        
        for (int i = A.length - K - 1; i >= 0; i--) {
        	curSum = (curSum + A[i] - A[i+K]) % mod;
        	kSum[i] = curSum; 
        }

        curSum = 0;
        for (int i = A.length - 1; i > A.length - 1 - L; i--)
        	curSum = (curSum + A[i]) % mod;
        lSum[A.length - L] = curSum;
        
        for (int i = A.length - L - 1; i >= 0; i--) {
        	curSum = (curSum + A[i] - A[i+L]) % mod;
        	lSum[i] = curSum; 
        }
        
        int maxK = 0, maxL = 0, maxSum = 0;
        for (int i = 0; i <= A.length - K - L; i++) {
        	// Consider i as the beginning of subarray of length K
        	maxK = kSum[i];
        	maxL = 0;
        	for (int j = i + K; j <= A.length - L; j++)
        		maxL = Math.max(maxL, lSum[j]);
        	maxSum = Math.max(maxSum, (maxK + maxL) % mod);
        	
        	// Consider i as the beginning of subarray of length L
        	maxL = lSum[i];
        	maxK = 0;
        	for (int j = i + L; j <= A.length - K; j++)
        		maxK = Math.max(maxK, kSum[j]);
        	maxSum = Math.max(maxSum, (maxK + maxL) % mod);
        }
        
        return maxSum;
    }
    
    public static void main(String args[]) {
    	int[] A = {6,1,4,6,3,2,7,4};
    	int K = 3, L = 2;
    	System.out.println(new Solution().solution(A, K, L));
    }
}