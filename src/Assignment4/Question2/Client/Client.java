package Assignment4.Question2.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.util.List;
import java.util.Map;


public class Client 
{
	public static void main(String[] args) 
	{
        try 
        {
            BookStore bookStore = (BookStore) Naming.lookup("rmi://localhost:1304/book");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the Book ID : ");
            int bookId = Integer.parseInt(br.readLine());
            List<Map<String, Object>> books = bookStore.getBookInfo(bookId);

            if (books.isEmpty()) 
            {
                System.out.println("Book Not Found...!");
            } 
            else 
            {
            	for (Map<String, Object> book : books) {
            	    for (Map.Entry<String, Object> entry : book.entrySet()) {
            	        String key = entry.getKey();
            	        Object value = entry.getValue();
            	        System.out.println(key + ": " + value);
            	    }
            	    System.out.println("-----------------------------"); 
            	}
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
