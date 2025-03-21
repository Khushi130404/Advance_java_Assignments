package Assignment4.Question3.Server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SystemInfoClass extends UnicastRemoteObject implements SystemInfo 
{
    protected SystemInfoClass() throws RemoteException 
    {
        super();
    }

    @Override
    public Map<String, Object> getSystemInfo() throws RemoteException 
    {
        Map<String, Object> systemInfo = new HashMap<>();

        systemInfo.put("OS Name", System.getProperty("os.name"));
        systemInfo.put("OS Version", System.getProperty("os.version"));

        File disk = new File("/");
        long totalSpace = disk.getTotalSpace() / (1024 * 1024 * 1024);
        long freeSpace = disk.getFreeSpace() / (1024 * 1024 * 1024);
        systemInfo.put("Total Disk Size (GB)", totalSpace);
        systemInfo.put("Available Disk Size (GB)", freeSpace);

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory() / (1024 * 1024);
        long freeMemory = runtime.freeMemory() / (1024 * 1024);
        long usedMemory = totalMemory - freeMemory;
        systemInfo.put("Total Memory (MB)", totalMemory);
        systemInfo.put("Used Memory (MB)", usedMemory);
        systemInfo.put("Free Memory (MB)", freeMemory);

        return systemInfo;
    }
}
