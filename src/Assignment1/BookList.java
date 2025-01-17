package Assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BookList {

    FileReader fileReader;
    BufferedReader bufferedReader;
	BookList()
	{
		try 
		{
			fileReader = new FileReader("book_list.dat");
			bufferedReader = new BufferedReader(fileReader);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	List<Book> readBookList()
	{
        List<Book> books = new ArrayList<>();
        try 
        {
            String line;
            while ((line = bufferedReader.readLine()) != null) 
            {
                StringTokenizer st = new StringTokenizer(line, "*");
                Book b = new Book(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    Float.parseFloat(st.nextToken()),
                    Integer.parseInt(st.nextToken())
                );
                books.add(b);
            }
            bufferedReader.close();
            fileReader.close();
        } 
        catch (Exception exp) 
        {
            exp.printStackTrace();
        }
        return books;
	}
}
