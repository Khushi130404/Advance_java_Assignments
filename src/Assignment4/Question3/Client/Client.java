package Assignment4.Question3.Client;

import java.rmi.Naming;
import java.util.Map;
import Assignment4.Question3.Server.SystemInfo;

public class Client 
{
    public static void main(String[] args) 
    {
        try 
        {
            SystemInfo systemInfo = (SystemInfo) Naming.lookup("rmi://localhost:1099/sys");
            Map<String, Object> info = systemInfo.getSystemInfo();
            System.out.println("System Information:");
            info.forEach((key, value) -> System.out.println(key + ": " + value));
        } 
        catch (Exception e) 
        {
            System.out.println("Client Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
