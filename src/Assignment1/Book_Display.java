package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Book_Display {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Book Display");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        List<Book> books = new ArrayList<>();
        try {
            FileReader fr = new FileReader("book_list.dat");
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

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(230, 230, 250));

        for (Book book : books) {
            JPanel bookPanel = new JPanel();
            bookPanel.setLayout(new GridLayout(4, 2, 10, 5));
            bookPanel.setBorder(BorderFactory.createTitledBorder("Book ID: " + book.getBookId()));
            bookPanel.setBackground(Color.WHITE);
            
            bookPanel.add(new JLabel("Book Name: " + book.getBookName()));
            bookPanel.add(new JLabel("Author: " + book.getAuthorNames()));
            bookPanel.add(new JLabel("Publication: " + book.getPublication()));
            bookPanel.add(new JLabel("Date: " + book.getDateOfPublication()));
            bookPanel.add(new JLabel("Price: " + book.getPriceOfBook()));
            bookPanel.add(new JLabel("Quantity: " + book.getTotalQuantityToOrder()));
            bookPanel.add(new JLabel("Total Cost: " + book.getTotalCost()));
            
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(scrollPane);
        
        frame.setVisible(true);
    }
}
