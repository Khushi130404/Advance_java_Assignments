package Assignment3.Question6;

import java.io.DataInputStream;
import java.io.DataOutputStream;

class HandleClientRequest 
{
    DataInputStream serverInputStream;
    DataOutputStream serverOutputStream;

    HandleClientRequest(DataInputStream serverInputStream, DataOutputStream serverOutputStream) 
    {
        this.serverInputStream = serverInputStream;
        this.serverOutputStream = serverOutputStream;
    }

    synchronized String writeToServer(String req) 
    {
        String data = "";
        try 
        {
            this.serverOutputStream.writeUTF(req);
            System.out.println("Request sent for file: " + req);
            data = this.serverInputStream.readUTF();
            return data;
        } 
        catch(Exception e) 
        {
            System.out.println("Error ...");
            System.out.println(e);
            data = "Some Error Occurred";
        }
        return data;
    }
}