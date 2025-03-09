package Assignment3.Question4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class TCPEchoClient 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket socket = new Socket("localhost",2323);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			String line = "";
			System.out.print("Enter Message : ");
			while(!(line=br.readLine()).equalsIgnoreCase("END"))
			{
				ps.println(line);
				System.out.print("Enter Message : ");
			}
			ps.println("END");
			ps.close();
			br.close();
			socket.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
