package Assignment3.Question6;

import java.net.*;
import java.util.*;
import java.io.*;

class Client 
{
    public static void main(String args[]) 
    {
        try 
        {
            Scanner sc = new Scanner(System.in);
            Socket socket = new Socket("localhost", 8081);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String str = "";
            String data = "";
            do 
            {
                System.out.print("Enter the file name: ");
                str = sc.next();
                dataOutputStream.writeUTF(str);
                System.out.println("Request sent ...");
                data = dataInputStream.readUTF();
                System.out.println("Server Response: ");
                System.out.println(data);
                System.out.println();
            } 
            while(!str.equals("exit"));
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
            sc.close();
        } 
        catch(Exception e) 
        {
            System.out.println("Error on Client ...");
            System.out.println(e);
        }
    }
}