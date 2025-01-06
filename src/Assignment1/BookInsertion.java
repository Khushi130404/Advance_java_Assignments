package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;

public class BookInsertion {

    public static void main(String[] args) {
      
        JFrame frame = new JFrame("Book Insertion Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));

        JLabel labelBookId = new JLabel("Book ID:");
        JTextField textBookId = new JTextField();

        JLabel labelBookName = new JLabel("Book Name:");
        JTextField textBookName = new JTextField();

        JLabel labelAuthorNames = new JLabel("Author Names:");
        JTextField textAuthorNames = new JTextField();

        JLabel labelPublication = new JLabel("Publication:");
        JTextField textPublication = new JTextField();

        JLabel labelDateOfPublication = new JLabel("Date of Publication:");
        JTextField textDateOfPublication = new JTextField();

        JLabel labelPriceOfBook = new JLabel("Price of Book:");
        JTextField textPriceOfBook = new JTextField();

        JLabel labelTotalQuantity = new JLabel("Total Quantity to Order:");
        JTextField textTotalQuantity = new JTextField();

        JLabel labelTotalCost = new JLabel("Total Cost:");
        JTextField textTotalCost = new JTextField();

        JButton submitButton = new JButton("Insert Book");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
         
            	Book b = new Book(Integer.parseInt(textBookId.getText()),textBookName.getText(),textAuthorNames.getText(),textPublication.getText(),textDateOfPublication.getText(),Float.parseFloat(textPriceOfBook.getText()),Integer.parseInt(textTotalQuantity.getText()),Float.parseFloat(textTotalCost.getText()));
                
                try
                {
                	FileWriter fw = new FileWriter("book_list.txt",true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(b.bookId+"*"+b.bookName+"*"+b.authorNames+"*"+b.publication+"*"+b.dateOfPublication+"*"+b.priceOfBook+"*"+b.totalQuantityToOrder+"*"+b.totalCost);
                    bw.newLine();
                    bw.close();
                    fw.close();
                }
                catch (Exception exp) {
					exp.printStackTrace();
				}
                
                JOptionPane.showMessageDialog(frame, "Book Inserted:\n" +
                        "Book ID: " + b.bookId + "\n" +
                        "Book Name: " + b.bookName + "\n" +
                        "Author Names: " + b.authorNames + "\n" +
                        "Publication: " + b.publication + "\n" +
                        "Date of Publication: " + b.dateOfPublication + "\n" +
                        "Price of Book: " + b.priceOfBook + "\n" +
                        "Total Quantity to Order: " + b.totalQuantityToOrder + "\n" +
                        "Total Cost: " + b.totalCost);
            }
        });

        panel.add(labelBookId);
        panel.add(textBookId);

        panel.add(labelBookName);
        panel.add(textBookName);

        panel.add(labelAuthorNames);
        panel.add(textAuthorNames);

        panel.add(labelPublication);
        panel.add(textPublication);

        panel.add(labelDateOfPublication);
        panel.add(textDateOfPublication);

        panel.add(labelPriceOfBook);
        panel.add(textPriceOfBook);

        panel.add(labelTotalQuantity);
        panel.add(textTotalQuantity);

        panel.add(labelTotalCost);
        panel.add(textTotalCost);

        panel.add(new JLabel()); // Empty space
        panel.add(submitButton);

        // Add the panel to the frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
