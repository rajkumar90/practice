package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class PermutationInString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null)
            return s1 == null && s2 == null;
        
        Integer[] arr1 = new Integer[26];
        List<Integer> list1 = Arrays.asList(arr1);
        Collections.fill(list1, 0);
        for (int i = 0; i < s1.length(); i++) {
            list1.set(s1.charAt(i) - 'a', list1.get(s1.charAt(i) - 'a') + 1);
        }
        
        Integer[] arr2 = new Integer[26];
        List<Integer> list2 = Arrays.asList(arr2);
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            Collections.fill(list2, 0);
            for (int j = i; j < i + s1.length(); j++) {
                list2.set(s2.charAt(j) - 'a', list2.get(s2.charAt(j) - 'a') + 1);
            }
            if (list1.equals(list2))
                return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	PermutationInString_567 obj = new PermutationInString_567();
    	System.out.println(obj.checkInclusion("ab", "eidbdaooo"));
    }
}