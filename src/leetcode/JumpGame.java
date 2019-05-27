package leetcode;

public class JumpGame {

	public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0)
            return true;
        
        int maxReachedIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxReachedIndex && i + nums[i] > maxReachedIndex)
                maxReachedIndex = i + nums[i];
        }
        
        return maxReachedIndex >= nums.length - 1;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame obj = new JumpGame();
		int[] nums = {2,3,1,1,4};
		boolean result = obj.canJump(nums );
		System.out.println(result);
	}

}
