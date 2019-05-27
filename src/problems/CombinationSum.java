package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> printCombinationIterative(int[] arr) {
		int size = arr.length;
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		for (int i = 0; i < Math.pow(2, size); i++) {
			List<Integer> combination = new ArrayList<Integer>();
			for(int j = 0; j < size; j++) {
				if (((1 << j) & i) != 0)
					combination.add(arr[j]);
			}
			combinations.add(combination);
		}
		return combinations;
	}
	
	public static List<List<Integer>> printCombinationRecursive(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		List<List<Integer>> result =  new ArrayList<List<Integer>>();
		printCombinationRecursiveHelper(arr, 0, result, new Integer[arr.length], 0);
		return result;
	}
	
	public static void printCombinationRecursiveHelper(int[] arr, int index, List<List<Integer>> result, Integer[] cur, int curIndex) {
		if (index == arr.length) {
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(cur));
			list = list.subList(0, curIndex);
			result.add(list);
			return;
		}
		
		// without
		printCombinationRecursiveHelper(arr, index + 1, result, cur, curIndex);
		
		cur[curIndex] = arr[index];
		// with
		printCombinationRecursiveHelper(arr, index + 1, result, cur, curIndex + 1);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
//		System.out.println(1 << 5);
		List<List<Integer>> combinations = printCombinationRecursive(arr);
		System.out.println(combinations);
	}

}
