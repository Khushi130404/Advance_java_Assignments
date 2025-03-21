package Assignment4.Question2.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

public interface BookStore extends Remote
{
	public List<Map<String, Object>> getBookInfo(int id)throws RemoteException;
}
