package Assignment3.Question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;

public class MulticastFileSender 
{
	public static void main(String[] args) 
	{
        try 
        {
            InetAddress ip = InetAddress.getByName("localhost");
            InetSocketAddress groupAddr = new InetSocketAddress(ip, 2001);
            MulticastSocket server = new MulticastSocket();
            server.joinGroup(groupAddr, null);
            System.out.println("Server is running...");

            DatagramPacket packet;
            String filePath = "";

            while (true) 
            {
                // Receive File Path
                byte[] filePathByte = new byte[1024];
                packet = new DatagramPacket(filePathByte, filePathByte.length);
                server.receive(packet);

                filePath = new String(packet.getData(), 0, packet.getLength()).trim();
                if (filePath.equalsIgnoreCase("Quit")) break;

                System.out.println("Requested file: " + filePath);

                File f = new File(filePath);
                if (f.isFile()) 
                {
                    System.out.println("File found. Sending...");
                    BufferedReader reader = new BufferedReader(new FileReader(f));
                    String line;
                    while ((line = reader.readLine()) != null) 
                    {
                        byte[] fileContentByte = line.getBytes();
                        packet = new DatagramPacket(fileContentByte, fileContentByte.length, 
                                packet.getAddress(), packet.getPort());
                        server.send(packet);
                    }
                    reader.close();

                    // Send EOF signal
                    String eof = "EOF";
                    byte[] eofByte = eof.getBytes();
                    packet = new DatagramPacket(eofByte, eofByte.length, packet.getAddress(), packet.getPort());
                    server.send(packet);
                } 
                else 
                {
                    System.out.println("File Not Found");
                    String notFound  = "File not Found...!";
                    byte[] notFoundByte = notFound.getBytes();
                    packet = new DatagramPacket(notFoundByte, notFoundByte.length, packet.getAddress(), packet.getPort());
                    server.send(packet);
                }
            }
            System.out.println("Server shutting down...");
            server.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
	}
}
