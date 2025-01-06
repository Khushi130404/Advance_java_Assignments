package Assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Book_Display {

    public static void main(String[] args) {
        // Create a JFrame
        JFrame j = new JFrame("Book Display");
        j.setSize(800, 400);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a list of books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Java Programming", "James Gosling", "Sun Microsystems", "01-01-1995", 500.0f, 10, 5000.0f));
        books.add(new Book(2, "Effective Java", "Joshua Bloch", "Addison-Wesley", "05-05-2008", 650.0f, 8, 5200.0f));
        books.add(new Book(3, "Head First Java", "Kathy Sierra, Bert Bates", "O'Reilly Media", "02-06-2005", 450.0f, 15, 6750.0f));

        // Create a table model
        String[] columnNames = {"Book ID", "Book Name", "Author Names", "Publication", "Date of Publication", "Price of Book", "Total Quantity to Order", "Total Cost"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        // Add rows to the table model
        for (Book book : books) {
            Object[] rowData = {
                book.getBookId(),
                book.getBookName(),
                book.getAuthorNames(),
                book.getPublication(),
                book.getDateOfPublication(),
                book.getPriceOfBook(),
                book.getTotalQuantityToOrder(),
                book.getTotalCost()
            };
            tableModel.addRow(rowData);
        }

        // Create a JTable and set the model
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        j.add(scrollPane);
        j.setVisible(true);
    }
}
