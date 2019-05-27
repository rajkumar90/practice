package leetcode;

import java.util.ArrayList;
import java.util.List;

class Permutation_46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        result.add(temp);
        for (int i = 1; i < nums.length; i++) {
            result = permuteForElement(result, nums[i]);            
        }
        
        return result;
    }
    
    public List<List<Integer>> permuteForElement(List<List<Integer>> input, int num) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for (int i = 0; i < input.size(); i++) {
            List<Integer> curInput = input.get(i);            
            for (int j = 0; j <= curInput.size(); j++) {
                List<Integer> curOutput = new ArrayList<Integer>(curInput);
                if (j > 0 && curOutput.get(j-1) == num)
                	continue;
                curOutput.add(j, num);
//                if (output.indexOf(curOutput) == -1)
                    output.add(curOutput);
            }
        }
        
        return output;
    }
    
    public static void main(String args[]) {
    	Permutation_46 obj = new Permutation_46();
    	int[] nums = {1,1, 2};
    	List<List<Integer>> result = obj.permute(nums);
    	System.out.println(result);
    }
}