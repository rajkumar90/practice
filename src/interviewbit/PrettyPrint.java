package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class PrettyPrint {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
    	int size = 2 * A - 1;
    	
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < size; i++) {
        	ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[size]));
            result.add(a);
        }
        
        int currentVal = A;        
        
        int curSize = size;
        while (currentVal > 0) {
            int margin = size - curSize;
        for (int i = margin; i < curSize; i++) {
            result.get(i).set(margin, currentVal);
            result.get(margin).set(i, currentVal);
            
            result.get(i).set(curSize-1, currentVal);
            result.get(curSize - 1).set(i, currentVal);
        }
        
        
        curSize -= 1;
        currentVal --;
    }
    
    return result;
}
    
    public static void main(String args[]) {
    	PrettyPrint p = new PrettyPrint();
    	
    	ArrayList<ArrayList<Integer>> result = p.prettyPrint(4);
    	System.out.println(result);
    }
}