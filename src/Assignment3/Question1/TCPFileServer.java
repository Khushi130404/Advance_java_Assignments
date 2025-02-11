package Assignment3.Question1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPFileServer 
{
	public static void main(String[] args) 
	{
		try
		{
			// Connection With Client
			ServerSocket ss= new ServerSocket(5001);
	        System.out.println("Waiting for Client ...");
	        Socket stk=ss.accept();
	        System.out.println("Connection Established.");

	        DataInputStream dis=new DataInputStream(stk.getInputStream());
	        DataOutputStream dos=new DataOutputStream(stk.getOutputStream());

	        String filePath = "";
	        while(!filePath.equalsIgnoreCase("Quit"))
	        {
	        	// Get File
		        filePath=dis.readUTF();
		        if(filePath.equalsIgnoreCase("Quit")) break;
		        System.out.println(filePath+"...");
		        File f=new File(filePath);
		        if (f.isFile())
		        {
		            System.out.println("file found");
		        }
		        
		        // Read & Send File
		        BufferedReader reader = new BufferedReader(new FileReader(f));
		        String line;
		        while ((line = reader.readLine()) != null) 
		        {
		            dos.writeUTF(line);
		        }
		        dos.writeUTF("EOF");
		        reader.close();
	        } 
	        // Close
	        dis.close();
	        dos.close();
	        System.out.print("Connection Ended...");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
