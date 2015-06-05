package TreeSetExample;

import java.util.Comparator;

public class StudentComparator implements Comparator<Student>{

	public int compare(Student st1, Student st2) {
		return st1.getStudent().compareTo(st2.getStudent());
	}
}
