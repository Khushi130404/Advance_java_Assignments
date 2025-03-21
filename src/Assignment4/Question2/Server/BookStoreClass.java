package Assignment4.Question2.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookStoreClass extends UnicastRemoteObject implements BookStore
{
	int bookId;
	String bookName;
	String authorNames;
	String publication;
	String dateOfPublication;
	float priceOfBook;
	int totalQuantityToOrder;
	float totalCost;

	protected BookStoreClass() throws RemoteException 
	{
		super();
	}

	@Override
	public BookStore getBookInfo(int id) throws RemoteException {
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
	        PreparedStatement pst = con.prepareStatement("select * from book where bookId = ?");
	        pst.setInt(1, id);
	        ResultSet rs = pst.executeQuery();
	        if(rs.getFetchSize()==0)
	        {
	        	System.out.print("Book Not Found...!");
	        }
	        else
	        {
	        	rs.next();
	        	bookId = rs.getInt(1);
	        	bookName = rs.getString(2);
	        	authorNames = rs.getString(3);
	        	publication = rs.getString(4);
	        	dateOfPublication = rs.getString(5);
	        	priceOfBook = rs.getFloat(6);
	        	totalQuantityToOrder = rs.getInt(7);
	        	totalCost = rs.getFloat(8);
	        }
	        rs.close();
	        pst.close();
	        con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return this;
	}

}
