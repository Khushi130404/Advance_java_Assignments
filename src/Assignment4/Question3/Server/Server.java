package Assignment4.Question3.Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            SystemInfo systemInfo = new SystemInfoClass();
            LocateRegistry.createRegistry(1008); 
            Naming.rebind("rmi://localhost/SystemInfo", systemInfo);
            System.out.println("System Info RMI Server is running...");
        } 
        catch (Exception e) 
        {
            System.out.println("Server Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
