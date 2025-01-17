package Assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class BookDeletion 
{
	BookList bookList;
    File file;
    List<Book> books;
    Book book;

	
	public BookDeletion(Book book) 
	{
		this.book = book;
		this.file = new File("book_list.dat");
		this.bookList = new BookList();
		books = bookList.readBookList();
	}
	
	void deleteBook()
	{
//		books.remove(book);
		writeFile();
	}
	
	void writeFile() 
	{
	    try  
	    {
	    	FileWriter fileWriter = new FileWriter(file);
	    	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    	
	        for (Book b : books) 
	        {
	        	if(b.equals(book)) continue;
	            bufferedWriter.write(b.getBookId() + "*" + 
	                         b.getBookName() + "*" + 
	                         b.getAuthorNames() + "*" + 
	                         b.getPublication() + "*" + 
	                         b.getDateOfPublication() + "*" + 
	                         b.getPriceOfBook() + "*" + 
	                         b.getTotalQuantityToOrder());
	            bufferedWriter.newLine();
	        }
	        
	        bufferedWriter.close();
	        fileWriter.close();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        System.out.println("Error writing to file!");
	    }
	}
}
