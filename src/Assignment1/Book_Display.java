package Assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Book_Display {

    public static void main(String[] args) {
     
        JFrame j = new JFrame("Book Display");
        j.setSize(800, 400);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        List<Book> books = new ArrayList<>();
        try
        {

        	FileReader fr = new FileReader("book_list.txt");
        	BufferedReader br = new BufferedReader(fr);
            String line = null;
            while((line=br.readLine())!=null)
            {
            	String[] parts = line.split("\\*");
                Book b = new Book(
                    Integer.parseInt(parts[0]),   
                    parts[1],                     
                    parts[2],                     
                    parts[3],                     
                    parts[4],                     
                    Float.parseFloat(parts[5]),   
                    Integer.parseInt(parts[6]),   
                    Float.parseFloat(parts[7])    
                );
            	books.add(b);
            }
        	br.readLine();
            br.close();
            fr.close();
        }
        catch (Exception exp) {
			exp.printStackTrace();
		}
        
//        books.add(new Book(1, "Java Programming", "James Gosling", "Sun Microsystems", "01-01-1995", 500.0f, 10, 5000.0f));
//        books.add(new Book(2, "Effective Java", "Joshua Bloch", "Addison-Wesley", "05-05-2008", 650.0f, 8, 5200.0f));
//        books.add(new Book(3, "Head First Java", "Kathy Sierra, Bert Bates", "O'Reilly Media", "02-06-2005", 450.0f, 15, 6750.0f));

        String[] columnNames = {"Book ID", "Book Name", "Author Names", "Publication", "Date of Publication", "Price of Book", "Total Quantity to Order", "Total Cost"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

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

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        j.add(scrollPane);
        j.setVisible(true);
    }
}
