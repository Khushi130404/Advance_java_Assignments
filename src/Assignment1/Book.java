package Assignment1;

import java.util.Date;

public class Book {
	int bookId;
	String bookName;
	String authorNames;
	String publication;
	String dateOfPublication;
	float priceOfBook;
	
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
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorNames() {
		return authorNames;
	}

	public void setAuthorNames(String authorNames) {
		this.authorNames = authorNames;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public String getDateOfPublication() {
		return dateOfPublication;
	}

	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}

	public float getPriceOfBook() {
		return priceOfBook;
	}

	public void setPriceOfBook(float priceOfBook) {
		this.priceOfBook = priceOfBook;
	}

	public int getTotalQuantityToOrder() {
		return totalQuantityToOrder;
	}

	public void setTotalQuantityToOrder(int totalQuantityToOrder) {
		this.totalQuantityToOrder = totalQuantityToOrder;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	int totalQuantityToOrder;
	float totalCost;
	
	
}
