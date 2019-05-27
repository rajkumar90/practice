package leetcode;
class MinSubarraySum_209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        int h = 0, l = 0, min = Integer.MAX_VALUE, sumSoFar = 0;
        while (l < nums.length) {
            while (h < nums.length && sumSoFar < s) {
                sumSoFar += nums[h++];                
            }
            if (sumSoFar >= s)
            	min = Math.min(min, h - l);
            sumSoFar -= nums[l++];
        }
        
        if (min == Integer.MAX_VALUE)
            min = 0;
        return min;
    }
    
    public static void main(String[] args) {
    	MinSubarraySum_209 m = new MinSubarraySum_209();
    	int[] nums = {4,3};
    	System.out.println(m.minSubArrayLen(7, nums));
    }
}