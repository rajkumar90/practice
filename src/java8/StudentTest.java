package java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentTest {
	public static void main(String[] args) {
		Student s1 = new Student("a", 1);
		Student s2 = new Student("b", 2);
		
		Comparator<Student> byRank = (o1, o2) -> (o1.rank - o2.rank);
		List<Student> list = new ArrayList<Student>();
		list.add(s2);
		list.add(s1);
		Collections.sort(list, byRank);
		System.out.println(list);
	}
}
