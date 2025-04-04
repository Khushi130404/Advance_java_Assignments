package Assignment3.Question5.copy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPChatSender 
{
	public static void main(String[] args) 
	{
		try
		{
			DatagramSocket datagramSocket = new DatagramSocket(1234);
			DatagramPacket datagramPacket = null;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			InetAddress inetAddress = InetAddress.getByName("localhost");
			
			String message = "";
			while(!message.equalsIgnoreCase("END"))
			{
				// Read From Client
				byte b[] = new byte[1024];
				datagramPacket = new DatagramPacket(b,b.length);
				datagramSocket.receive(datagramPacket);
				message = new String(datagramPacket.getData()).trim();
				if(message.equalsIgnoreCase("END")) break;
				System.out.println("Client Request : "+message);
				
				// Write To Client
				System.out.print("Serever Response : ");
				message = br.readLine();
				datagramPacket = new DatagramPacket(message.getBytes(), message.length(),inetAddress,4321);
				datagramSocket.send(datagramPacket);
				if(message.equalsIgnoreCase("END")) break;
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
