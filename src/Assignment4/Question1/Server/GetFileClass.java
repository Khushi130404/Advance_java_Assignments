package Assignment4.Question1.Server;

import java.io.File;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GetFileClass extends UnicastRemoteObject implements GetFile {

	protected GetFileClass() throws RemoteException {
		super();
	}

	@Override
	public String readFile(String file_path) throws RemoteException 
	{
		String fileContent = "";
		try
		{
			File file = new File(file_path);
			FileReader fileReader = new FileReader(file);
			int n=-1;
			while((n = fileReader.read())!=-1)
			{
				fileContent+=(char)n;
			}
		}
		catch (Exception e) 
		{
			fileContent = "File Not Found";
			e.printStackTrace();
		}
		return fileContent;
	}
}
