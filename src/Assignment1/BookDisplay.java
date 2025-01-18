package Assignment1;

import java.util.List;

public class BookDisplay 
{
    public static void main(String[] args) 
    {
       BookList booklist = new BookList();
       List<Book> books = booklist.readBookList();
       DisplayFrame frame = new DisplayFrame(books);
    }
}
