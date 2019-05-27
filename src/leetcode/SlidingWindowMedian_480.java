package leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

class SlidingWindowMedian_480 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> b-a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a-b);
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new double[0];        
        
        double[] result = new double[nums.length - k + 1];
        // 1,3,-1,-3,5,3,6,7
        for (int i = 0; i < k; i++)
            addNumToHeap(nums[i]);
        result[0] = findMedian();
        
        for (int i = 1; i <= nums.length - k; i++) {
            deleteNumFromHeap(nums[i - 1]);
            System.out.println("After deletion - maxHeap: " + maxHeap + ":: minHeap: " + minHeap);            
            addNumToHeap(nums[i+k-1]);
            System.out.println("After addition - maxHeap: " + maxHeap + ":: minHeap: " + minHeap);
            result[i] = findMedian();
        }
        
        return result;
    }
    
    public void addNumToHeap(int num) {
    	System.out.println("Adding " + num);
        if ((maxHeap.isEmpty() && minHeap.isEmpty()) || (!maxHeap.isEmpty() && num <= maxHeap.peek()))
            maxHeap.add(num);
        else
            minHeap.add(num);
        
        if (maxHeap.size() - minHeap.size() >= 2)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() - maxHeap.size() >= 1)
            maxHeap.add(minHeap.poll());
    }
    
    public void deleteNumFromHeap(int num) {
    	System.out.println("Deleting " + num);
        if (num <= maxHeap.peek())
            maxHeap.remove(num);
        else
            minHeap.remove(num);
        
        if (maxHeap.size() - minHeap.size() >= 2)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() - maxHeap.size() >= 1)
            maxHeap.add(minHeap.poll());
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (((double)maxHeap.peek() + (double)minHeap.peek())) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }
    
    public static void main(String[] args) {
    	SlidingWindowMedian_480 s = new SlidingWindowMedian_480();
    	int[] nums = {-2147483648,-2147483648,2147483647};
    	double[] result = s.medianSlidingWindow(nums, 3);
    	System.out.println(Arrays.toString(result));
    }
}