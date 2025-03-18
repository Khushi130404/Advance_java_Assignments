package Assignment4.Question1.Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) 
	{
		try
		{
			GetFileClass getFileClass = new GetFileClass();
			Registry reg = LocateRegistry.createRegistry(1020);
			reg.bind("gfc", getFileClass);
		}
		catch (Exception e) 
		{
			System.out.println("Error : "+e.getMessage());
			e.printStackTrace();
		}
	}
}
