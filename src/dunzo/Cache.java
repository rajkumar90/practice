package dunzo;

/**
 * Interface for cache. Not making it generic since requirement is that both key and value are Strings
 * @author raj
 *
 */
public interface Cache {
	public String find(String key);
	public String set(String key, String val);
	
	public long getWriteTime();
	public long getReadTime();
	public int getLevel();
}
