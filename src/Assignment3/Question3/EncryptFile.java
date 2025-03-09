package Assignment3.Question3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class EncryptFile 
{
	 public static String encrypt(String content) 
	 {
		 return Base64.getEncoder().encodeToString(content.getBytes());
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
			File file = new File(fileName);
			FileReader fileReader = new FileReader(file);
			BufferedReader brFile = new BufferedReader(fileReader);
			String line = "";
			while((line = brFile.readLine())!=null)
			{
				String encryptedLine = encrypt(line);
				ps.println(encryptedLine);
			}
			brFile.close();
			fileReader.close();
			ps.close();
			br.close();
			// socket.close();
			// serverSocket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
