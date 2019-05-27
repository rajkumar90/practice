package dunzo;

import java.util.ArrayList;
import java.util.List;

public class CacheManagerImpl implements CacheManager {
	private List<Cache> cacheList;
	
	public CacheManagerImpl(int numLevels) {
		cacheList = new ArrayList<Cache>();
		for (int i = 1; i <= numLevels; i++) {
			// Can be made more configurable - Properties in enum or text file or via json
			cacheList.add(new CacheImpl(i, i * 5, i * 5, i * 10));
		}
	}
	
	@Override
	public String get(String key) {
		String val = null;
		long readTimeMs = 0;
		
		// Iterate through the cache levels
		int level = 0;
		for (Cache cache : cacheList) {
			val = cache.find(key);
			readTimeMs += cache.getReadTime();
			if (val != null) {
				level = cache.getLevel();
				break;				
			}
		}
		
		// TODO What if the key is not found in any cache level? Throw exception
		for (int i = 0; i < level; i++) {
			cacheList.get(i).set(key, val);
		}
		
		System.out.println("The value corresponding to key: " + key + " is " + val + " :: Read took " + readTimeMs + " ms");
		return val;
	}

	@Override
	public String put(String key, String val) {
		long writeTimeMs = 0;
		for (Cache cache : cacheList) {
			cache.set(key, val);
			writeTimeMs += cache.getWriteTime();
		}
		System.out.println("Write took " + writeTimeMs + " ms");
		return val;
	}

	@Override
	public void addLevel() {
	}

	@Override
	public void deleteLevel() {		
	}

}
