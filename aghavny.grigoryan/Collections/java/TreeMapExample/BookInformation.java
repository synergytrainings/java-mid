package TreeMapExample;

public class BookInformation{
	private Integer year;
	private String publishingHouse;
	
	public BookInformation(Integer year,String publishingHouse){
		this.year = year;
		this.publishingHouse = publishingHouse;
	}
	public String getBookInformation(){
		return this.year+ "/" + this.publishingHouse;
	}
}
