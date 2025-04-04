package Assignment3.Question2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class UDPFileServer 
{
    public static void main(String[] args) 
    {
        try 
        {
            DatagramSocket server = new DatagramSocket(2001);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
