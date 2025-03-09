package Assignment3.Question5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPChatReceiver 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket datagramSocket = new DatagramSocket(4321);
			DatagramPacket datagramPacket = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			InetAddress inetAddress = InetAddress.getByName("localhost");
			
			String message = "";
			while(!message.equalsIgnoreCase("END"))
			{
				// Write To Client
				System.out.print("Client Request : ");
				message = br.readLine();
				datagramPacket = new DatagramPacket(message.getBytes(), message.length(),inetAddress,1234);
				datagramSocket.send(datagramPacket);
				if(message.equalsIgnoreCase("END")) break;
				
				// Read From Client
				byte b[] = new byte[1024];
				datagramPacket = new DatagramPacket(b,b.length);
				datagramSocket.receive(datagramPacket);
				message = new String(datagramPacket.getData()).trim();
				if(message.equalsIgnoreCase("END")) break;
				System.out.println("Serever Response : "+message);	
			}
			
			br.close();
			datagramSocket.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
