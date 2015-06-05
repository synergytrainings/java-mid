package TreeSetExample;

import java.util.*;

public class Group {

	public static void  displayMyGroup(Set myGruop){
		 Iterator iterator = myGruop.iterator();
		 while (iterator.hasNext()){
			   System.out.println(((Student)iterator.next()).getStudent());
		 }
	}
	
	public static void main(String [] args) {
		Set myGroup = new TreeSet<Student>(new StudentComparator());
		myGroup.add(new Student("Anna", "Manoukayan", "Ak12345"));
		myGroup.add(new Student("Lilit", "Stepanyan", "A12345Z"));
		myGroup.add(new Student("Vahan", "Vardanyan", "Akz12345"));
		myGroup.add(new Student("Tigran", "Poghosyan", "Ak12345"));
		displayMyGroup(myGroup);

	}
}

