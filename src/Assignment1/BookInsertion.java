package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BookInsertion {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Book Insertion Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // Header
        JLabel headerLabel = new JLabel("Insert New Book Details", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Form Panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

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
        submitButton.setBackground(new Color(72, 191, 227));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);

        // Action Listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(Integer.parseInt(textBookId.getText()), textBookName.getText(), textAuthorNames.getText(), textPublication.getText(), textDateOfPublication.getText(), Float.parseFloat(textPriceOfBook.getText()), Integer.parseInt(textTotalQuantity.getText()), Float.parseFloat(textTotalCost.getText()));

                try {
                    FileWriter fw = new FileWriter("book_list.txt", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(b.bookId + "*" + b.bookName + "*" + b.authorNames + "*" + b.publication + "*" + b.dateOfPublication + "*" + b.priceOfBook + "*" + b.totalQuantityToOrder + "*" + b.totalCost);
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception exp) {
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

        // Adding Components to Panel
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

        // Footer Panel for Button
        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        footerPanel.add(submitButton);

        // Adding Components to Frame
        frame.add(headerLabel, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
