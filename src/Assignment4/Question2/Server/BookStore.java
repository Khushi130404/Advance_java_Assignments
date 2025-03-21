package Assignment4.Question2.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookStore extends Remote
{
	public BookStore getBookInfo(int id)throws RemoteException;
}
