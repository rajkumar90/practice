package cr.generics;

public class Stats<T extends Number> {
	T[] arr;
	
	Stats(T[] arr) {
		this.arr = arr;
	}
	
	public double getAvg() {
		double sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i].doubleValue();
		}
		
		return sum / arr.length;
	}
	
	public boolean isSameAvg(Stats<?> other) {
		if (getAvg() == other.getAvg())
			return true;
		else
			return false;
	}
}
