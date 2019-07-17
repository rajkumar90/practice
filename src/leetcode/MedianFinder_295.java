package leetcode;

import java.util.PriorityQueue;

class MedianFinder_295 {
    PriorityQueue<Integer> maxHeap;
    
    PriorityQueue<Integer> minHeap;
    
    /** initialize your data structure here. */
    public MedianFinder_295() {
        maxHeap = new PriorityQueue<Integer>((a,b) -> b - a);
        minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        if (maxHeap.size() == 0 || num < maxHeap.peek())
            maxHeap.add(num);
        else {
            minHeap.add(num);
        }
        
        if (maxHeap.size() - minHeap.size() >= 2)
            minHeap.add(maxHeap.poll());
        else if (minHeap.size() - maxHeap.size() >= 2)
            maxHeap.add(minHeap.poll());
        System.out.println("MaxHeap: " + maxHeap + " :: Minheap: " + minHeap);
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return ((double)(maxHeap.peek() + minHeap.peek())) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }
    
    public static void main(String[] args) {
    	MedianFinder_295 m = new MedianFinder_295();
    	m.addNum(1);
    	m.addNum(2);
    	m.addNum(3);
    	System.out.println(m.findMedian());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */