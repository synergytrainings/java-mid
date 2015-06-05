package TreeMapExample;

public class Book implements Comparable<Book> {
	private static int count = 1;
	private String author;
	private String bookName;
	private String bookInformation;
	
	public Book (String author, String name , int year, String publishingHouse){
		this.author = author;
		this.bookName = name;
		this.setBookInformation(year, publishingHouse);
	}
	
	public void setBookInformation(int year, String publishingHouse){
		this.bookInformation = new BookInformation(year, publishingHouse).getBookInformation();
	}
	
	public String getBookInformation(){
		return this.bookInformation;
	}
	public String getBookKey(){
		 return this.getBook() + this.getBookInformation();
	}
	 
	public String getAuthor(){
		return this.author;
	}

	public String getBookName(){
		return this.bookName;
	} 
	public int compareTo(Book otherBook){
		return this.getBookKey().compareTo(otherBook.getBook());
		}
		
	public String getBook(){
		return  this.getAuthor() + ":"  + this.getBookName(); 
	}
}

