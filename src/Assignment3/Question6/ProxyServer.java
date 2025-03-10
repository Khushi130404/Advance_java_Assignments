package Assignment3.Question6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;

class ProxyServer 
{
    public static void main(String args[]) 
    {
        ServerSocket serverSocket = null;
        Socket server = null;
        Socket client = null;
        DataInputStream serverInputStream = null;
        DataOutputStream serverOutputStream = null;
        HandleClientRequest handleClientRequest = null;
        try 
        {
            serverSocket = new ServerSocket(8081);
            server = new Socket("localhost", 8082);
            serverInputStream = new DataInputStream(server.getInputStream());
            serverOutputStream = new DataOutputStream(server.getOutputStream());
            handleClientRequest = new HandleClientRequest(serverInputStream, serverOutputStream);
            while(true) 
            {
                client = serverSocket.accept();
                ClientRequest newClient = new ClientRequest(client, handleClientRequest);
                newClient.start();
                System.out.println("New Client Connected ...");
            }

        } 
        catch(Exception e) 
        {
            System.out.println("Error on Proxy Server ...");
            System.out.println(e);
        } 
        finally 
        {
            try 
            {
                serverOutputStream.close();
                serverInputStream.close();
                server.close();
                serverSocket.close();
            } 
            catch(Exception e) 
            {
            	e.printStackTrace();
            }
        }
    }
}