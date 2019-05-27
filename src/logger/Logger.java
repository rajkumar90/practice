package logger;

public interface Logger {
	public void info(String msg);
	public void warn(String msg);
	public void debug(String msg);
	public void add(String msg);
}
