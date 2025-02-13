package Assignment3.Question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPFileServer 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket server = new DatagramSocket(2001);
			InetAddress ip = InetAddress.getByName("localhost");
			DatagramPacket packet;
	        String filePath = "";

	        while(!filePath.equalsIgnoreCase("Quit"))
	        {
	        	// Get File
				byte[] filePathByte = new byte[1024];
				packet = new DatagramPacket(filePathByte,filePathByte.length,ip,1304);
	        	server.receive(packet);
				filePathByte = packet.getData();
		        filePath = new String(filePathByte);
				
				if(filePath.equalsIgnoreCase("Quit")) break;
		        System.out.println(filePath+"...");
		        File f=new File(filePath);
		        if (f.isFile())
		        {
			        // Read & Send File
		            System.out.println("File found");
		            BufferedReader reader = new BufferedReader(new FileReader(f));
			        String line;
			        while ((line = reader.readLine()) != null) 
			        {
						byte[] fileContentByte = new byte[1024];
			        	packet = new DatagramPacket(fileContentByte,fileContentByte.length,ip,1304);
			            server.send(packet);
			        }
			        String eof = "EOF";
			    	byte[] eofByte = new byte[1024];
			        packet = new DatagramPacket(eofByte,eofByte.length,ip,1304);
			        server.send(packet);
		        }
		        else
		        {
		        	System.out.println("File Not Found");
		        }
	        }
	        server.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
