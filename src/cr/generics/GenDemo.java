package cr.generics;

public class GenDemo {

	public static void main(String[] args) {
		Gen<Integer> i = new Gen<Integer>(8);
		i.showType();
		
		int v = i.getObj();
		System.out.println("v: " + v );
	}

}
