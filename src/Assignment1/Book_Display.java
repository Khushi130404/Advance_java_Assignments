package Assignment1;

import java.util.List;

public class Book_Display {
    public static void main(String[] args) {

       BookList booklist = new BookList();
       List<Book> books = booklist.readBookList();
       DisplayFrame frame = new DisplayFrame(books);
    }
}
