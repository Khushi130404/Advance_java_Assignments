package Assignment4.Question1.Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import Assignment4.Question1.Server.GetFile;

public class Client 
{    
	public static void main(String[] args) 
    {
        try 
        {
            GetFile getFileClass = (GetFile) Naming.lookup("rmi://localhost:1020/gfc");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter the file Name : ");
            String file = br.readLine();
            System.out.println("\nFile Content...");
            String fileContent = getFileClass.readFile(file);
            System.out.println(fileContent);
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}
