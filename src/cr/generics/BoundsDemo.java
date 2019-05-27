package cr.generics;

public class BoundsDemo {
	public static void main(String[] args) {
		Integer[] inums = {1,2,3,4,5};
		Stats<Integer> iStats = new Stats<Integer>(inums);
		System.out.println(iStats.getAvg());
	}
}
