package Assignment3.Question4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPEchoServer 
{
	public static void main(String[] args) 
	{
		try
		{
			ServerSocket serverSocket = new ServerSocket(2323);
			System.out.println("Waiting for client....");
			Socket socket = serverSocket.accept();
			System.out.println("Client Connected");
		
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line = "";
			while(!(line=br.readLine()).equalsIgnoreCase("END") && !socket.isClosed())
			{
				System.out.println(line);
			}
			
			br.close();
//			socket.shutdownOutput();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
