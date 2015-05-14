package com.synisys.training.main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.mockrunner.mock.jdbc.MockResultSet;
import com.synisys.training.anonymous.Employee;
import com.synisys.training.anonymous.EmployeeManagementSystem;
import com.synisys.training.inner.CompanyStaff;
import com.synisys.training.nested.DogPatient;
import com.synisys.training.nested.utility.DogBreed;
import com.synisys.training.nested.utility.DogGender;

public class Main {
	public static void main(String[] args) {

		/* usage of the anonymous class */
		EmployeeManagementSystem system = new EmployeeManagementSystem();
		system.hireEmployee("Joshua Bloch", 340000, 32);
		Employee employeeIsJoshua = system.meetEmployee("Joshua Bloch");
		System.out.println("New Employee:" + employeeIsJoshua.getName() + ", His salary is :" + employeeIsJoshua.getSalary());

		System.out.println("---------------------------------");
		
		/* usage of the static inner class */
		Calendar date = Calendar.getInstance();
		date.set(2009, 12, 1, 0, 0);
		DogPatient dogPatient = new DogPatient.DogPatientBuilder("Toto","Anush Hakobyan", date, DogGender.Male)
				.breed(DogBreed.Mixed).color("Foxy").weight(14).build();
		System.out.println("Dog Name:" + dogPatient.getDogName() + ", Owner Name:" + dogPatient.getOwnerName()
				+ ", Dog Breed:" + dogPatient.getBreed());
		
		System.out.println("---------------------------------");
		
		/* usage of the inner class */
		MockResultSet rs = new MockResultSet("myMock");
		rs.addColumn("FirstName", new String[]{"Joshua"});
		rs.addColumn("LastName", new String[]{"Bloch"});
		rs.addColumn("Experience", new Integer[]{32});
		rs.addColumn("Salary", new Double[]{(double) 390000});
		ResultSet resultSet = rs;
		CompanyStaff companyStaff = new CompanyStaff();
		try {
			companyStaff.loadStaff(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(companyStaff.meetStaffMember("Joshua Bloch").getSalary());
		
		System.out.println("---------------------------------");
		
	}
	
}
