package Assignment3.Question3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class DecryptFile 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket socket = new Socket("localhost",5421);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			BufferedReader brFile = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the File Name : ");
			String fileName = brFile.readLine();
			ps.println(fileName);
			brFile.close();
			
			String line = "";
			while((line=br.readLine())!=null)
			{
				
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}

}
