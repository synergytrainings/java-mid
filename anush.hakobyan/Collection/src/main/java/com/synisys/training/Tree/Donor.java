package com.synisys.training.Tree;

public class Donor implements Comparable<Donor> {
	
	private final int donorId;
	private final String donorName;
	private Double totalInvestment;
	private Integer overallProjectCount;
	
	public Donor(int donorId, String donorName) {
		this.donorId = donorId;
		this.donorName = donorName;
	}

	public int getDonorId() {
		return this.donorId;
	}
	
	public Integer getOverallProjectCount() {
		return this.overallProjectCount;
	}

	public void setOverallProjectCount(Integer overallProjectCount) {
		this.overallProjectCount = overallProjectCount;
	}

	public Double getTotalInvestment() {
		return this.totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public String getDonorName() {
		return this.donorName;
	}

	private Double getAverageInvestment() {
		return this.getTotalInvestment()/this.overallProjectCount;
	}
	
	public int compareTo(Donor donor) {
		if(this.equals(donor)) {
			return 0;
		}
		if(this.getAverageInvestment() > donor.getAverageInvestment()) {
			return 1;
		}
		return -1;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(!(obj instanceof  Donor)) {
			return false;
		}
		
		Donor donor = (Donor)obj;
		
		return (this.donorId == donor.getDonorId() &&
				this.donorName.equals(donor.getDonorName()));
	}
	
	
}
