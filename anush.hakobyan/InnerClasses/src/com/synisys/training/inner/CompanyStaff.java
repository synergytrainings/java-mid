package com.synisys.training.inner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.synisys.training.anonymous.Employee;

public class CompanyStaff {
	
	private HashMap<String,Employee> staff = new HashMap<String,Employee>();

	public HashMap<String,Employee> getStaff() {
		return staff;
	}
	
	/**
	 * Load Employees into HashMap from the database
	 * @param result
	 * @throws SQLException 
	 */
	public void loadStaff(ResultSet resultSet) throws SQLException {
		EmployeeDataMapping employeeMapping = new EmployeeDataMapping();
		while(resultSet.next()) {
			employeeMapping.mapDataToEmployee(resultSet);			
		}
	}
	
	public Employee meetStaffMember(String employeeName) {
		return staff.get(employeeName);
	}
	
	
	private class EmployeeDataMapping implements EmployeeDataMapper {
		/**
		 * Creates mapping between the resultSet came from the database and Employee.
		 * Puts the employee in the staff.
		 */
		@Override
		public void mapDataToEmployee(ResultSet resultSet)  {
			String employeeName;
			int employeeSalary;
			int employeeExperience;
			try {
				employeeName = resultSet.getString("FirstName") + " " + resultSet.getString("LastName");
				employeeSalary = resultSet.getInt("Salary");
				employeeExperience = resultSet.getInt("Experience");
				Employee employee = new Employee(employeeName, employeeSalary, employeeExperience);
				staff.put(employeeName, employee);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

}
