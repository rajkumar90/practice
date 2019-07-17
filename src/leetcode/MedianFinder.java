package leetcode;
import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> min, max;
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>((i, j) -> j.compareTo(i));
    }
    
    public void addNum(int num) {
        max.add(num);
        
        min.add(max.poll());
        if (max.size() < min.size())
            max.add(min.poll());
        
        System.out.println("MaxHeap: " + max + " :: Minheap: " + min);
    }
    
    public double findMedian() {
        if (max.size() == min.size())
            return (double)(max.peek() + min.peek()) / 2;
        else
            return max.peek();
    }
    
    public static void main(String[] args) {
    	MedianFinder m = new MedianFinder();
    	m.addNum(1);
    	m.addNum(2);
    	m.addNum(3);
    	System.out.println(m.findMedian());
    }
}
