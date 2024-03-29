package leetcode;
class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 1;
        
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != i+1) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i]; 
                nums[i] = temp;
            }
        }
        
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                return i+1;
        
        return nums.length + 1;
    }
    
    public static void main(String[] args) {
    	FirstMissingPositive_41 f = new FirstMissingPositive_41();
    	int[] nums = {7,8,9,10,11,12};
		System.out.println(f.firstMissingPositive(nums ));
    }
}