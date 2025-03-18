package Assignment4.Question1.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GetFile extends Remote
{
	String readFile(String file) throws RemoteException;
}
