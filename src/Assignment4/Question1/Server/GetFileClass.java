package Assignment4.Question1.Server;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetFileClass extends UnicastRemoteObject implements GetFile 
{
    protected GetFileClass() throws RemoteException 
    {
        super();
    }

    @Override
    public String readFile(String file_path) throws RemoteException 
    {
        StringBuilder fileContent = new StringBuilder();

        try 
        {
            File file = new File(file_path);
            if (!file.exists() || !file.isFile()) 
            {
                return "File Not Found";
            }

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) 
            {
                String line;
                while ((line = fileReader.readLine()) != null) 
                {
                    fileContent.append(line).append("\n");
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
            return "Error reading file: " + e.getMessage();
        }
        return fileContent.toString();
    }
}
