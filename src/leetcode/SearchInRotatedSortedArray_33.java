package leetcode;
class SearchInRotatedSortedArray_33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        
        int l = 0, h = nums.length - 1;
        return searchHelper(nums, target, l, h);
    }
    
    // 4,5,6,7,0,1,2
    public int searchHelper(int[] nums, int target, int l, int h) {
        if (nums == null || nums.length == 0)
            return -1;
        
        while (l <= h) {
            int m = l + (h - l)/2;
            if (nums[m] == target)
                return m;                        
                        
            if (nums[m] >= nums[l]) {
                if (target >= nums[l] && target <= nums[m])
                	return searchHelper(nums, target, l, m-1);
                else
                	return searchHelper(nums, target, m+1, h);
                	
            } else {
                // Second half is sorted
                if (target > nums[m] && target <= nums[h])
                	return searchHelper(nums, target, m+1, h);
                else
                	return searchHelper(nums, target, l, m-1);
            }            
            
        }
        return -1;
    }
    
    public int binarySearch(int[] nums, int target, int l, int h) {
        if (nums == null || nums.length == 0)
            return -1;
        
        while (l <= h) {
            int m = l + (h - l)/2;
            if (nums[m] == target)
                return m;

            else if (target > nums[m])
                l = m + 1;
            else
                h = m - 1;
            
        }
        
        return -1;
    }
    
    public static void main(String args[]) {
    	SearchInRotatedSortedArray_33 s = new SearchInRotatedSortedArray_33();
    	int arr[] = {3,1};
    	System.out.println(s.search(arr, 1));
    }
}