package Assignment3.Question1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TCPFileClient 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket socket = new Socket("localhost",5001);
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("Connection Established");
			Scanner scan = new Scanner(System.in);
			
			// Send File Name to Server
			String fileName = "";
			while(!fileName.equals("Quit")) 
			{
				System.out.print("\nEnter the File Name : ");
				fileName = scan.next() ;
				if(fileName.equalsIgnoreCase("Quit")) break;
				dos.writeUTF(fileName);
				
				// Read File from Server
				System.out.println("File Content....");
				String fileContent = dis.readUTF();
				while(!fileContent.equals("EOF"))
				{
					System.out.println(fileContent);
					fileContent = dis.readUTF();
				}
				System.out.println("End Of File....\n");
			}		
			dos.writeUTF("Quit");
			
			// Close
			dos.close();
			dis.close();
			socket.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
