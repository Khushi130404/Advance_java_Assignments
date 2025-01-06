package Assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Book_Display {

    public static void main(String[] args) {
     
        JFrame j = new JFrame("Book Display");
        j.setSize(1300, 1000);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);  
        
        List<Book> books = new ArrayList<>();
        try {
            FileReader fr = new FileReader("book_list.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "*");
                Book b = new Book(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    Float.parseFloat(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Float.parseFloat(st.nextToken())
                );
                books.add(b);
            }
            br.close();
            fr.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        Font colFont = new Font("Arial", Font.PLAIN, 18);  
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

        Font tableFont = new Font("Arial", Font.PLAIN, 18);  
        table.setFont(tableFont);
        table.setRowHeight(28);  
        
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);        
        panel.setBackground(new Color(230, 230, 250));  
        j.add(panel);
        j.setVisible(true);
    }
}
