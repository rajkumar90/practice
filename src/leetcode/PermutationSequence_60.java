package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class PermutationSequence_60 {
    public int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
    
    public String getPermutation(int n, int k) {
        Integer arr[] = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = new LinkedList<Integer>(Arrays.asList(arr));
        String result = "";
        k--;
        while(n > 0) {
            int factorial = factorial(n-1);
            int index = k / (factorial);
            result += list.get(index);
            list.remove(index);
            n--;
            k = k % (factorial);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	PermutationSequence_60 obj = new PermutationSequence_60();
    	System.out.println(obj.getPermutation(3,1));
    }
}