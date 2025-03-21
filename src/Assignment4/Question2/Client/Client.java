package Assignment4.Question2.Client;

import Assignment4.Question2.Server.BookStore;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Map;


public class Client 
{
	public static void main(String[] args) 
	{
        try 
        {
        	Registry registry = LocateRegistry.getRegistry("localhost", 1304);
        	BookStore bookStore = (BookStore) registry.lookup("b");
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
            	for (Map<String, Object> book : books) 
            	{
            	    for (Map.Entry<String, Object> entry : book.entrySet()) 
            	    {
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
