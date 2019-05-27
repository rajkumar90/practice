package leetcode;

import java.util.ArrayList;
import java.util.List;

class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) 
            arr[i] = i+1;
        
        return combineHelper(arr, k, 0);
    }
    
    public List<List<Integer>> combineHelper(int[] arr, int k, int index) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (arr == null || arr.length == 0 || k == 0 || index >= arr.length) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        for (int  i = index; i <= arr.length - k; i++) {            
            List<List<Integer>> combinationList = combineHelper(arr, k-1, i+1);
            for (List<Integer> combination : combinationList) {
                List<Integer> temp = new ArrayList<Integer>(combination);
                temp.add(0, arr[i]);
                result.add(temp);
            }            
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	Combinations_77 c = new Combinations_77();
    	List<List<Integer>> result = c.combine(4,2);
    	System.out.println(result);
    }
}