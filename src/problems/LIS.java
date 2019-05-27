package problems;

import java.util.Arrays;

public class LIS {

	int[][] table = new int[100][100];
	public int lisRecursive(int nums[]) {
		if (nums == null || nums.length == 0)
			return 0;
		return lisRecursiveHelper(nums, nums.length - 1);
	}
	
	public int lisRecursiveHelper(int nums[], int index) {
		int curLis = 1, lisSoFar = 1;
		if (index == 0)
			return 1;
		for (int i = index-1; i >= 0; i--) {
			int prevLis = lisRecursiveHelper(nums,  i);
			if (nums[index] > nums[i]) {
				curLis = Math.max(curLis, prevLis + 1);
				lisSoFar = Math.max(lisSoFar, curLis);
			} else {
				lisSoFar = Math.max(prevLis, lisSoFar);
			}
		}		
		return lisSoFar;
	}
	
	/*
	public int lisTopDown(int nums[], int index) {
		int lisEndingHere = 1, lisSoFar = 1;
		if (index == 0)
			return 1;
		for (int i = index-1; i >= 0; i--) {
			int prevLis = lisRecursiveHelper(nums,  i);
			if (nums[index] > nums[i]) {
				lis = Math.max(lis, prevLis + 1);
			}
			else
				lis = Math.max(lis, 1);
		}		
		return lis;
	}
	*/
	
	public int lisDP(int nums[]) {
		int table[] = new int[nums.length];
		Arrays.fill(table, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					table[i] = Math.max(table[i], table[j] + 1);
				}
			}
		}
		int max = 0;
		for (int i = 0; i < table.length; i++)
			max = (table[i] > max)?table[i]:max;
			
		return max;
	}
	
	public int findNumberOfLIS(int[] nums) {
		int table[] = new int[nums.length];
		Arrays.fill(table, 1);
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] > nums[j]) {
					table[i] = Math.max(table[i], table[j] + 1);
				}
			}
		}
		int max = 0; int numMax = 0;
		for (int i = 0; i < table.length; i++) {
            if (table[i] > max) {
                max = table[i];
                numMax = 1;
            } else if (table[i] == max) {
                numMax++;
            }
        }
			
		return numMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LIS lis = new LIS();
		int[] nums = {1, 3, 5, 4, 7};
		int result = lis.findNumberOfLIS(nums);
		System.out.println(result);
	}

}
