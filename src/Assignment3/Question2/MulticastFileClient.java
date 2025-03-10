package Assignment3.Question2;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastFileClient 
{
	public static void main(String[] args) 
	{
        try 
        {
            InetAddress ip = InetAddress.getByName("172.24.11.98");
            InetSocketAddress groupAddr = new InetSocketAddress(ip, 2001);
            MulticastSocket client = new MulticastSocket(1304);
            client.joinGroup(groupAddr, null);
            Scanner scan = new Scanner(System.in);
            String filePath = "";
            while (true) 
            {
                // Get file name from user
                System.out.print("\nEnter the File Name (or 'Quit' to exit): ");
                filePath = scan.next();
                if (filePath.equalsIgnoreCase("Quit")) break;

                // Send file name to server
                byte[] filePathByte = filePath.getBytes();
                DatagramPacket packet = new DatagramPacket(filePathByte, filePathByte.length, ip, 2001);
                client.send(packet);

                // Receive file content
                System.out.println("Receiving file content...");
                while (true) 
                {
                    byte[] fileContentByte = new byte[1024];
                    packet = new DatagramPacket(fileContentByte, fileContentByte.length);
                    client.receive(packet);

                    String fileContent = new String(packet.getData(), 0, packet.getLength()).trim();
                    if (fileContent.equalsIgnoreCase("EOF"))
                    {
                        System.out.println("End Of File...\n");
                    	break;
                   	}
                    if(fileContent.equalsIgnoreCase("File not Found...!"))
                    {
                        System.out.println("File Not Found...\n");
                    	break;
                   	}
                    System.out.println(fileContent);
                }

            }

            // Send quit signal to server
            String quit = "Quit";
            byte[] quitByte = quit.getBytes();
            DatagramPacket quitPacket = new DatagramPacket(quitByte, quitByte.length, ip, 2001);
            client.send(quitPacket);

            System.out.println("Client shutting down...");
            client.close();
            scan.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
