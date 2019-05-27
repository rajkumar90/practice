package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer, Integer>{  
	private static final long serialVersionUID = 1L;
	int cacheSize;
    LRUCache(int size) {
    	super(size, 1, true);
    	this.cacheSize = size;    	
    }      
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
    	return (size() > cacheSize);
    }
    
    @Override
    public Integer get(Object key) {
    	Integer val = super.get(key);
    	return (val == null) ? -1 : val;
    }
	
    public static void main(String args[]) {
    	LRUCache cache = new LRUCache(2);
    	cache.put(1, 1);
    	System.out.println(cache);
    	cache.put(2, 2);
    	System.out.println(cache);
    	System.out.println(cache.get(1));
    	
    	cache.put(3, 3);
    	System.out.println(cache);
    	System.out.println(cache.get(2));
    }
}