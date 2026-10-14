package File;
import Entity.*;
import EntityList.*;
import java.io.*;
import java.util.*;

public class FileIO{
	public static void loadFromFile(BookList bookList){
		try{
			Scanner sc = new Scanner(new File("./File/BookData.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				Book b = new Book(data[0],data[1],data[2],data[3],Integer.parseInt(data[4]));
				bookList.insert(b);
			}
			sc.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static void writeBookInFile(Book b){
		try{
			FileWriter writer = new FileWriter(new File("./File/BookData.txt"),true);
			String data = b.getBookId()+";"+b.getBookName()+";"+
						  b.getBookAuthor()+";"+b.getBookType()+";"+
						  b.getBookCopy()+"\n";
			writer.write(data);
			writer.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static void updateBooksInFile(BookList bookList){
		try{
			FileWriter writer = new FileWriter(new File("./File/BookData.txt"));
			Book books[] = bookList.getAllBooks();
			
			String allData="";
			
			for(int i=0;i<books.length;i++){
				if(books[i]!=null){
					String data = books[i].getBookId()+";"+books[i].getBookName()+";"+
						  books[i].getBookAuthor()+";"+books[i].getBookType()+";"+
						  books[i].getBookCopy()+"\n";
					
					allData+=data;
				}
			}
			writer.write(allData);
			writer.close();
		}
		catch(Exception e){
			
		}
	}
	
	
	public static boolean checkUserFromFile(String userName,String userPass){
		try{
			Scanner sc = new Scanner(new File("./File/UserData.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");
				if(data[0].equals(userName) && data[1].equals(userPass)){
					sc.close();
					return true;
				}				
			}
			sc.close();
		}
		catch(Exception e){
			
		}
		return false;
	}
	
	
}