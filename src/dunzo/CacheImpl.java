package dunzo;

import java.util.LinkedHashMap;

public class CacheImpl extends LinkedHashMap<String, String> implements Cache {
	private static final long serialVersionUID = 1L;
	private int level;
	private int capacity;
	private long readTime;
	private long writeTime;
	
	/*
	 * One option is to use a concurrent hash map - This can handle concurrency but will not achieve O(1) for read and write, if we use LRU for eviction
	 * Another option is to use linked hash map to get O(1) for read and write but this cannot achieve concurrency unless we use 'synchronized' (Using 'synchronized' is not efficient as using ConcurrentHashMap though)
	 */
	
	CacheImpl(int level, int capacity, int readTime, int writeTime) {
		super(capacity + 1, 1.0f, true);
		this.level = level;
		this.capacity = capacity;
		this.readTime = readTime;
		this.writeTime = writeTime;
				
	}
	
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<String, String> eldest) {
		// Remove the eldest element whenever size of cache exceeds the capacity
		return (size() > this.capacity);
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public long getReadTime() {
		return readTime;
	}

	public void setReadTime(long readTime) {
		this.readTime = readTime;
	}

	public long getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(long writeTime) {
		this.writeTime = writeTime;
	}

	public synchronized String find(String key) {
		return super.get(key);
	}

	public synchronized String set(String key, String val) {
		super.put(key, val);		
		return val;
	}

}
