import Entity.Book;
import EntityList.BookList;
import GUI.*;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class StartGUI{
	public static void main(String []args){

		BookList bookList = new BookList(100);
		
		bookList.insert( new Book("01","B1","BA 1","C1",7) );
		bookList.insert( new Book("02","B2","BA 2","C1",8) );
		bookList.insert( new Book("03","B3","BA 3","C2",3) );
		bookList.insert( new Book("04","B4","BA 4","C2",5) );
		bookList.insert( new Book("05","B5","BA 5","C2",5) );
		bookList.insert( new Book("06","B6","BA 5","C2",5) );

		//System.out.println("=== Welcome to Library Management System ===");
		//System.out.println("========= Developed By Java Sec Y ==========");
		
		
		BookManagementGUI bmGUI = new BookManagementGUI(bookList);
		
	}
}