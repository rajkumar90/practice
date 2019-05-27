package leetcode;

public class SortColors_75 {
	public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        
        int low = -1, mid = 0, high = nums.length;
        
        while (low < high && mid < high) {           
            if (nums[mid] == 0) {
                nums[mid++] = nums[++low];
                nums[low] = 0;
            } else if (nums[mid] == 2){
                nums[mid] = nums[--high];
                nums[high] = 2;
            } else {
            	mid++;
            }
        }        
    }
	
	public static void main(String[] args) {
		SortColors_75 s = new SortColors_75();
		int nums[] = {2,0,2,1,1,0};
		s.sortColors(nums);
		System.out.println(nums);
	}

}
