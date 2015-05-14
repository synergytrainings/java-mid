package com.synisys.training.nested;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.synisys.training.nested.utility.DogBreed;
import com.synisys.training.nested.utility.DogGender;

public class DogPatient {

	private final String dogName;
	private final String ownerName;
	private final Calendar birthDate;
	private final int weight;
	private final DogBreed breed;
	private final String color;
	private final DogGender gender;
	private ArrayList<String> diseases;
	private ArrayList<String> vaccines;
	private Date lastVaccineDate;

	private DogPatient(DogPatientBuilder dogBuilder) {
		dogName = dogBuilder.dogName;
		ownerName = dogBuilder.ownerName;
		birthDate = dogBuilder.birthDate;
		weight = dogBuilder.weight;
		breed = dogBuilder.breed;
		color = dogBuilder.color;
		gender = dogBuilder.gender;
		diseases = dogBuilder.diseases;
		vaccines = dogBuilder.vaccines;
		lastVaccineDate = dogBuilder.lastVaccineDate;
	}

	public String getDogName() {
		return dogName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public int getWeight() {
		return weight;
	}

	public DogBreed getBreed() {
		return breed;
	}

	public String getColor() {
		return color;
	}

	public DogGender getGender() {
		return gender;
	}
	
	public static class DogPatientBuilder {
		/* required parameters */
		private final String dogName;
		private final String ownerName;
		private final Calendar birthDate;
		private final DogGender gender;

		/* optional parameters */
		private int weight = 0;
		private DogBreed breed = null;
		private String color = "unknown";
		private ArrayList<String> vaccines = new ArrayList<String>();
		private ArrayList<String> diseases;
		private Date lastVaccineDate = null;

		public DogPatientBuilder(String dogName, String ownerName,
				Calendar birthDate, DogGender gender) {
			this.dogName = dogName;
			this.ownerName = ownerName;
			this.birthDate = birthDate;
			this.gender = gender;
		}

		public DogPatientBuilder weight(int weight) {
			this.weight = weight;
			return this;
		}

		public DogPatientBuilder breed(DogBreed breed) {
			this.breed = breed;
			return this;
		}

		public DogPatientBuilder color(String color) {
			this.color = color;
			return this;
		}

		public DogPatientBuilder vaccines(ArrayList<String> vaccines) {
			this.vaccines = vaccines;
			return this;
		}

		public DogPatientBuilder lastVaccineDate(Date lastVaccineDate) {
			this.lastVaccineDate = lastVaccineDate;
			return this;
		}
		
		public DogPatientBuilder diseases(ArrayList<String> diseases) {
			this.diseases = diseases;
			return this;
		}
		
		public DogPatient build() {
			return new DogPatient(this);
			}
	}


}
