package com.synisys.training.anonymous;

import java.util.HashMap;

public class EmployeeManagementSystem {
	
	private HashMap <String, Employee> Employees = new HashMap<String, Employee>();
	
	/**
	 * Creates new employee with the given information. 
	 * Raises employee's salary depending on the work experience.
	 * 
	 * @param employeeName name of the new employee
	 * @param previousSalary salary before new job
	 * @param i work experience in years that has the new employee
	 */
	public void hireEmployee(String employeeName, double previousSalary, int experience) {
		Employee newEmployee = new Employee(employeeName, previousSalary, experience ) {
			@Override
			 public void raiseSalary(double raiseCoeficient) {
				 double starterSalary = this.getSalary() + Employee.MINIMUM_SALARY * raiseCoeficient;
				 this.setSalary(starterSalary);
			 }
		};
		double coeficient = experience/(double)25;
		newEmployee.raiseSalary(coeficient);
		Employees.put(employeeName , (Employee)newEmployee);
	}
	
	
//	public void fireEmployee() {
//		
//	}
//	
	
	public Employee meetEmployee(String employeeName) {
		return Employees.get(employeeName);
	}
	
	
	
}
