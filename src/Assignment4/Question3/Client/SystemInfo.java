package Assignment4.Question3.Client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface SystemInfo extends Remote 
{
    Map<String, Object> getSystemInfo() throws RemoteException;
}
