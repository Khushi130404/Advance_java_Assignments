package Assignment3.Question3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EncryptFile 
{
	public static String readFile(String fileName)throws Exception
	{
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader brFile = new BufferedReader(fileReader);
		String fileContent = "";
		String fc = "";
		while((fc = brFile.readLine())!=null)
		{
			fileContent+=("\n"+fc);
		}
		brFile.close();
		fileReader.close();
		return fileContent;
	}
	
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(5421);
			System.out.print("Waiting for client....");
			Socket socket = serverSocket.accept();
			System.out.print("Client Connected");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			String fileName = br.readLine();
			String fileContent = readFile(fileName);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
