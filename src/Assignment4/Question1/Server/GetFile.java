package Assignment4.Question1.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetFile extends Remote
{
	String readFile(String file) throws RemoteException;
}
