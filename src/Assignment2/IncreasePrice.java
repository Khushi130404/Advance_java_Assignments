package Assignment2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class IncreasePrice 
{

    Connection con;
	CallableStatement cst;
	
	public IncreasePrice() 
	{
		increasePriceOfBooks();
	}
	
	void increasePriceOfBooks()
	{
        try 
        {	
        	Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
			cst = con.prepareCall("{ call update_book_prices() }");
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
