package Assignment2;

import java.sql.*;

public class BookUpdatation 
{
    Connection con;
    Book book;
	PreparedStatement prs;
	CallableStatement cst;

	public BookUpdatation(Book book) 
	{
		this.book = book;
	}
	
	void updateBook()
	{
        try 
        {	
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
			prs = con.prepareStatement("update book set bookName = ?, authorNames = ?, publication = ?, dateOfPublication = ?, priceOfBook = ?, totalQuantityToOrder = ? where bookId = ?");
            prs.setString(1, book.getBookName());
            prs.setString(2, book.getAuthorNames());
            prs.setString(3, book.getPublication());
            prs.setString(4, book.getDateOfPublication());
            prs.setDouble(5, book.getPriceOfBook());
            prs.setInt(6, book.getTotalQuantityToOrder());
            prs.setInt(7, book.getBookId());
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
