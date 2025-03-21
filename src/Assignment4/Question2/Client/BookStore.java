package Assignment4.Question2.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookStore extends Remote
{
	public BookStore getBookInfo(int id)throws RemoteException;
}
