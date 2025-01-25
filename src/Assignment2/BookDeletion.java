package Assignment2;

import java.sql.*;
import javax.swing.JOptionPane;

public class BookDeletion 
{
    Connection con;
    Book book;
	PreparedStatement prs;

	public BookDeletion(Book book) 
	{
		this.book = book;
	}
	
	public int showDeleteConfirmation() 
	{
        return JOptionPane.showConfirmDialog(
            null, 
            "Are you sure you want to remove this book ?", 
            "Confirm Deletion", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.WARNING_MESSAGE
        );
    }
	
	void deleteBook() 
	{
	    try  
	    {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
            prs = con.prepareStatement("delete from book where bookId = ?");
        	prs.setInt(1, book.getBookId());
            prs.execute();
            prs.close();
            con.close();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        System.out.println("Error writing to file!");
	    }
	}
}
