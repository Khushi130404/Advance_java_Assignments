package Assignment4.Question1.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            GetFile getFileClass = new GetFileClass(); 
            Registry reg = LocateRegistry.createRegistry(1020);
            reg.bind("gfc", getFileClass);
            // Naming.rebind("gfc", getFileClass);
            System.out.println("Server is running...");
        } 
        catch (Exception e) 
        {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
