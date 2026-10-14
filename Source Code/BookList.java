package EntityList;
import Entity.Book;

public class BookList{
	private Book books[];
	public BookList(){
		books = new Book[5];
	}
	public BookList(int size){
		books = new Book[size];
	}
	
	public void insert(Book b){
		boolean flag = false;
		for(int i=0;i<books.length;i++){
			if(books[i] == null){
				books[i] = b;
				flag = true;
				break;
			}
		}
		if(flag){System.out.println("Insertion Successfull");}
		else{System.out.println("Insertion Failed");}
	}
	
	public Book getById(String id){
		for(int i=0;i<books.length;i++){
			if(books[i] != null){
				if(books[i].getBookId().equals(id)){
					return books[i];
				}
			}
		}
		return null;
	}
	
	public void deleteById(String id){
		boolean flag = false;
		for(int i=0;i<books.length;i++){
			if(books[i] != null){
				if(books[i].getBookId().equals(id)){
					books[i] = null;
					flag = true;
					break;
				}
			}
		}
		if(flag){System.out.println("Deletion Successfull");}
		else{System.out.println("Deletion Failed");}
	}
	
	
	public void searchByName(String name){
		for(int i=0;i<books.length;i++){
			if(books[i] != null){
				if(books[i].getBookName().equals(name)){
					System.out.println("+++ Book Found +++");
					books[i].showBookInfo();
					return;
				}
			}
		}
		System.out.println("-- Book Not Found ---");
		return;
	}
	
	public void showAll(){
		System.out.println("++++++ List of All Available Books ++++++");
		for(int i=0;i<books.length;i++){
			if(books[i] != null){ //looking for book objects
			System.out.println("---------------------");
				books[i].showBookInfo();
			}
		}
		System.out.println("---------------------");
	}
	
	public String getAll(){
		String allBooks = "";
		
		for(int i=0;i<books.length;i++){
			if(books[i] != null){ //looking for book objects
				allBooks += "------------------------\n";
				allBooks += books[i].getBookInfoAsString();
			}
		}
		allBooks += "------------------------\n";
		return allBooks;
	}
	
}