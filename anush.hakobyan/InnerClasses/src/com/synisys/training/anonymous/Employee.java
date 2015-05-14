package com.synisys.training.anonymous;

public class Employee {
	
	public static final int MINIMUM_SALARY = 40000;
	
	private final String name;
	private double salary;
	private int experience;
	
	public Employee(String name, double salary, int experience){
		this.name = name;
		this.salary = salary;
		this.experience = experience;
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void raiseSalary(double raisedBy) {
		this.salary = this.salary + raisedBy;
	}
	
	protected void setSalary(double salary) {
		this.salary = salary;
	}
}
