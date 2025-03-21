package Assignment2;

import java.sql.*;

public class BookInsertion 
{
    Connection con;
    Book book;
	PreparedStatement prs;
	CallableStatement cst;
    
    public BookInsertion(Book book) 
    {
    	this.book = book;
	}
    
    void insertBook()
    {
        try 
        {	
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
			prs = con.prepareStatement("insert into book (bookId, bookName, authorNames, publication, dateOfPublication, priceOfBook, totalQuantityToOrder) values(?,?,?,?,?,?,?)");
	    	prs.setInt(1, book.getBookId());
            prs.setString(2, book.getBookName());
            prs.setString(3, book.getAuthorNames());
            prs.setString(4, book.getPublication());
            prs.setString(5, book.getDateOfPublication());
            prs.setDouble(6, book.getPriceOfBook());
            prs.setInt(7, book.getTotalQuantityToOrder());
            prs.execute();
            prs.close();
            cst = con.prepareCall("{ call set_total_cost(?) }");
            cst.setInt(1, book.getBookId());
            cst.execute();
            cst.close();
            con.close();
		} 
        catch (Exception e)
        {
			e.printStackTrace();
		}
    }
}
