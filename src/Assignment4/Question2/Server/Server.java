package Assignment4.Question2.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            BookStore bookStore = new BookStoreClass();
            Registry reg = LocateRegistry.createRegistry(1304);
            reg.bind("book", bookStore);
            System.out.println("Server is running...");
        } 
        catch (Exception e) 
        {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
