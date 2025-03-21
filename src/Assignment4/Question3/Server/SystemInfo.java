package Assignment4.Question3.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SystemInfo extends Remote 
{
    String getOSVersion() throws RemoteException;
    String getDiskSpace() throws RemoteException;
    String getMemoryStatus() throws RemoteException;
}

