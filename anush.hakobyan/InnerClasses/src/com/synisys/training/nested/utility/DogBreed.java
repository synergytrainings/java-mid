package com.synisys.training.nested.utility;

public enum DogBreed {
	Foxhound("Foxhound"), Staffordshire_Terrier("American Staffordshire Terrier"), Spaniel("Cocker Spaniel"), Australian_Shepherd("Australian Shepherd"), 
	Basenji("Basenji"), Dalmatian("Dalmatian"), Pinscher("German Pinscher"), Mixed("Mix of several breeds");  
	
	private final String breedName;
	
	DogBreed(String breedName) {
		this.breedName = breedName;
	}

	public String getBreedName() {
		return breedName;
	}
}
