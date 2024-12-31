package Assignment1;

import java.util.Date;

public class Book {
	int bookId;
	String bookName;
	String authorNames;
	String publication;
	String dateOfPublication;
	float priceOfBook;
	int totalQuantityToOrder;
	float totalCost;
	
	Book(){}
	
	Book(int bookId,String bookName,String authorNames,String publication,String dateOfPublication,float priceOfBook,int totalQuantityToOrder,float totalCost)
	{
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorNames = authorNames;
		this.publication = publication;
		this.dateOfPublication = dateOfPublication;
		this.priceOfBook = priceOfBook;
		this.totalQuantityToOrder = totalQuantityToOrder;
		this.totalCost = totalCost;
	}
	
}
