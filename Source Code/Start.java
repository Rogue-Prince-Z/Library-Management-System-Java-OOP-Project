import java.util.Scanner;
import Entity.Book;
import EntityList.BookList;

public class Start{
	public static void main(String []args){
		Scanner scNum = new Scanner(System.in);
		Scanner scStr = new Scanner(System.in);
		
		BookList bookList = new BookList(100);
		
		bookList.insert( new Book("01","B1","BA 1","C1",7) );
		bookList.insert( new Book("02","B2","BA 2","C1",8) );
		bookList.insert( new Book("03","B3","BA 3","C2",3) );
		bookList.insert( new Book("04","B4","BA 4","C2",5) );
		bookList.insert( new Book("05","B5","BA 5","C2",5) );
		bookList.insert( new Book("06","B6","BA 5","C2",5) );

		System.out.println("=== Welcome to Library Management System ===");
		System.out.println("========= Developed By Java Sec Y ==========");
		
		while(true){
			System.out.println("++++++++++++++++++++++++++++");
			System.out.println("1. Show Available Books");
			System.out.println("2. Insert a New Book");
			System.out.println("3. Show a Book");
			System.out.println("4. Delete a Book");
			System.out.println("5. Search a Book By Name");
			System.out.println("6. Update a Book");
			System.out.println("0. Exit");
			
			System.out.print("Enter an Option: ");
			int option = scNum.nextInt();
			
			if(option == 1){
				bookList.showAll();
			}
			else if(option == 2){
				System.out.println("Enter The Details of The Book");
				
				System.out.print("Book ID:");
				String bookId = scStr.nextLine();

				System.out.print("Book Name:");
				String bookName = scStr.nextLine();
				
				System.out.print("Book Author:");
				String bookAuthor = scStr.nextLine();
				
				System.out.print("Book Type:");
				String bookType = scStr.nextLine();
				
				System.out.print("Book Copy:");
				int copy = scNum.nextInt();
				bookList.insert(new Book(bookId,bookName,bookAuthor,bookType,copy));
			}
			else if(option == 3){
				
			}
			else if(option == 4){
				System.out.println("Enter The ID of The Book to be Deleted");
				
				System.out.print("Book ID:");
				String bookId = scStr.nextLine();
				bookList.deleteById(bookId);
				
			}
			else if(option == 5){
				System.out.println("Enter The Name of The Book to Search");
				
				System.out.print("Book Name:");
				String bookName = scStr.nextLine();
				bookList.searchByName(bookName);
			}
			else if(option == 6){
				System.out.println("Enter The ID of The Book to Update");
				System.out.print("Book ID:");
				String bookId = scStr.nextLine();
				
				Book b = bookList.getById(bookId);
				while(true){
					System.out.println("-------------------");
					System.out.println("1. Update Name");
					System.out.println("2. Update Author Name");
					System.out.println("3. Update Type");
					System.out.println("4. Add Copy ");
					System.out.println("5. Update Copy");
					System.out.println("0. <- Back");
					System.out.print("Enter an Option: ");
					int subOption = scNum.nextInt();
					if(subOption == 1){
						System.out.print("Book Name:");
						String bookName = scStr.nextLine();
						b.setBookName(bookName);
						System.out.println("----After Update----");
						b.showBookInfo();
					}
					else if(subOption == 2){
						
					}
					else{
						break;
					}
				}
			}
			else{
				break;
			}
			
		}
		
		System.out.println("=========Thank You for Using Our System==========");
		
		
	}
}