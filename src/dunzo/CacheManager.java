package dunzo;

public interface CacheManager {
	public String get(String key);
	public String put(String key, String val);
	
	public void addLevel();
	public void deleteLevel();
}
