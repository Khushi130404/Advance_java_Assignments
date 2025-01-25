package Assignment2;

import java.sql.*;
import java.util.*;

public class BookList 
{
    Connection con;
    Statement st;
    ResultSet rs;

	BookList()
	{}
	
	List<Book> readBookList()
	{
        List<Book> books = new ArrayList<>();
        try 
        {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
	        st = con.createStatement();
	        rs = st.executeQuery("select * from book");
	        
        	while(rs.next())
	        {
        		Book book = new Book();
        		book.setBookId(rs.getInt(1));
        		book.setBookName(rs.getString(2));
        		book.setAuthorNames(rs.getString(3));
        		book.setPublication(rs.getString(4));
        		book.setDateOfPublication(rs.getString(5));
        		book.setPriceOfBook(rs.getFloat(6));
        		book.setTotalQuantityToOrder(rs.getInt(7));
        		books.add(book);
	        }
        	
        	rs.close();
        	st.close();
        	con.close();
        } 
        catch (Exception exp) 
        {
            exp.printStackTrace();
        }
        return books;
	}
}
