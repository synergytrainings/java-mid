package TreeSetExample;

public class Student  {
	private String name;
	private String surname;
	private String registerNumber;
	
	public Student (String name, String surname,String registerNumber){
		this.name = name;
		this.surname = surname;
		this.registerNumber = registerNumber;
	}
	 public String getStudent() {
		 return this.name + " " + this.surname + " " + this.registerNumber;
	 }
 @Override 
	 public boolean equals(Object obj) { 
		 if (obj == this) { return true; } 
		 if (obj == null || obj.getClass() != this.getClass()) { return false; } 
		 Student guest = (Student) obj; 
		 return name.equals(guest.name) && surname.equals(guest.surname) && registerNumber.equals(guest.registerNumber) ; 
	}
 }


