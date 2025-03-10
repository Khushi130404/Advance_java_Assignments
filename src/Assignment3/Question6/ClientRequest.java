package Assignment3.Question6;

import java.net.*;
import java.io.*;

class ClientRequest extends Thread 
{
    Socket client;
    DataInputStream clientInputStream;
    DataOutputStream clientOutputStream;
    HandleClientRequest handleClientRequest;

    ClientRequest(Socket client, HandleClientRequest handleClientRequest) 
    {
        try 
        {
            this.client = client;
            this.handleClientRequest = handleClientRequest;
            this.clientInputStream = new DataInputStream(client.getInputStream());
            this.clientOutputStream = new DataOutputStream(client.getOutputStream());
        } 
        catch(Exception e) 
        {
            System.out.println("Error in processing client request ...");
            System.out.println(e);
        }
    }
    
    public void run() 
    {
        try 
        {
            String req = "";
            String data = "";
            while(true) 
            {
                req = clientInputStream.readUTF();
                if(!req.equals("exit")) 
                {
                    data = this.handleClientRequest.writeToServer(req);
                } 
                else 
                {
                    data = "Disconnecting the client ...";
                }
                clientOutputStream.writeUTF(data);
            }
        } 
        catch(Exception e) 
        {
            System.out.println("Error in processing client request ...");
            System.out.println(e);
        } 
        finally 
        {
            try 
            {
                this.clientInputStream.close();
                this.clientOutputStream.close();
                this.client.close();
            }
            catch(Exception e) 
            {
            	e.printStackTrace();
            }
        }
    }
}