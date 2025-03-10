package Assignment3.Question6;

import java.net.*;
import java.io.*;

class Server 
{
    public static void main(String args[]) 
    {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        File file = null;
        FileInputStream fileInputStream = null;
        String req = "";
        String data = "";
        byte[] arr = new byte[1024];
        
        try 
        {
            serverSocket = new ServerSocket(8082);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            dataInputStream = new DataInputStream(inputStream);
            dataOutputStream = new DataOutputStream(outputStream);
            while(true) 
            {
                try 
                {
                    req = dataInputStream.readUTF();
                    System.out.println("Request received for file: " + req);
                    file = new File("../" + req);
                    if(file.exists()) 
                    {
                        fileInputStream = new FileInputStream(file);
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fileInputStream.read(buffer)) != -1) 
                        {
                            byteArrayOutputStream.write(buffer, 0, bytesRead);
                        }
                        arr = byteArrayOutputStream.toByteArray();
                        fileInputStream.close();
                        data = new String(arr);
                    } 
                    else 
                    {
                        data = "File Not Found ...";
                    }
                } 
                catch(Exception e) 
                {
                    System.out.println("Error while processing request ...");
                    System.out.println(e);
                    data = "Internal Server Error ...";
                } 
                finally 
                {
                    dataOutputStream.writeUTF(data);
                }
            }
        } 
        catch(Exception e) 
        {
            System.out.println("Error on Server ...");
            System.out.println(e);
        } 
        finally 
        {
            try 
            {
                dataOutputStream.close();
                dataInputStream.close();
                outputStream.close();
                inputStream.close();
                socket.close();
                serverSocket.close();
            } 
            catch(Exception e) 
            {
            	e.printStackTrace();
            }
        }
    }
}