package java8;

public class Student {
	String name;
	Integer rank;
	
	Student(String name, int rank) {
		this.name = name;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rank=" + rank + "]";
	}
	
	
}
