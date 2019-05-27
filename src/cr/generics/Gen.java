package cr.generics;

public class Gen<T> {
	T obj;
	
	Gen(T obj) {
		this.obj = obj;
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}
	
	void showType() {
		System.out.println("Type of T is : " + obj.getClass().getName());
	}
}
