package cr.generics;

public class WildcardDemo {

	public static void main(String[] args) {
		Integer[] inums = {1,2,3,4,5};
		Stats<Integer> iStats = new Stats<Integer>(inums);
		
		Double[] dnums = {1.0, 2.0, 3.0};
		Stats<Double> dStats = new Stats<Double>(dnums);
		
		System.out.println(iStats.isSameAvg(dStats));
	}

}
