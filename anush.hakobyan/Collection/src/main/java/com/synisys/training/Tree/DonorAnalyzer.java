package com.synisys.training.Tree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

public class DonorAnalyzer {
	
	TreeSet<Donor> DonorInvestmentTree = new TreeSet<Donor>();
	
	/**
	 * Adds donors form the resultSet to TreeSet
	 * 
	 * @param resultSet contains donors loaded from the database
	 * @throws SQLException if the columnLabel is not valid;
     * 						if a database access error occurs 
     * 						or this method is called on a closed result set
	 */
	public void addDonors(ResultSet resultSet)  {
		try {
			while(resultSet.next()) {
				int donorId = resultSet.getInt("DonorId");
				String donorName = resultSet.getString("DonorName");
				Double totalInvestment =  resultSet.getDouble("Investment");
				Integer overallProjectCount = resultSet.getInt("ProjectsCount");
				Donor donor = new Donor(donorId, donorName);
				donor.setOverallProjectCount(overallProjectCount);
				donor.setTotalInvestment(totalInvestment);
				DonorInvestmentTree.add(donor);			
			}
		} catch (SQLException ex){
			ex.printStackTrace();
			System.out.println("SQlException while iterating over resultSet"); 
		} finally {
			try {
				if(resultSet!=null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("SQlException while closing resultSet"); 
			}
		}
		
	}
	
	public void addDonor(Donor donor) {
		this.DonorInvestmentTree.add(donor);	
	}
	
	public TreeSet<Donor> getDonorsSortedList() {
		return this.DonorInvestmentTree;
	}
	
}
