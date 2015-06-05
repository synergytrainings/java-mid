package TreeMapExample;
import java.util.*;
public class Library {
	public static void getLibrary(Map<Book, String> library){
		for(Map.Entry e : library.entrySet()){
			 
		    System.out.println(((Book)e.getKey()).getBook() + "/" + ((Book)e.getKey()).getBookInformation());
		}
	}
	
	public static void updateAllKeys(Map<Integer, Book> library){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Book, String> treeMap = new TreeMap<Book, String>();
		Book b1 = new Book("Drayzer", "Genius", 1992, "BlueStar");
		treeMap.put( b1, b1.getBook());
		Book b2  = new Book("Drayzer", "American Tragedy", 1984, "DreamLight");
		treeMap.put(b2, b2.getBook());
		Book b3 = new Book("Drayzer", "Genius", 2001, "Eskmo");
		treeMap.put(b3,b3.getBook());
		getLibrary(treeMap);
	}
	

}
