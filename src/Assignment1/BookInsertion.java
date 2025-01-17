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

        String labelText[] = {"Book ID:","Book Name:","Author Names:","Publication:","Date of Publication:","Price of Book:","Total Quantity to Order:"};
        JLabel label[] = new JLabel[labelText.length];
        
        
        for(int i=0; i<label.length; i++)
        {
        	label[i] = new JLabel(labelText[i]);
        }
        
        JTextField textBookId = new JTextField();

        JTextField textBookName = new JTextField();

        JTextField textAuthorNames = new JTextField();

        JTextField textPublication = new JTextField();

        JTextField textDateOfPublication = new JTextField();

        JTextField textPriceOfBook = new JTextField();

        JTextField textTotalQuantity = new JTextField();

        JButton submitButton = new JButton("Insert Book");
        submitButton.setBackground(new Color(72, 191, 227));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);

        // Action Listener for Submit Button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(Integer.parseInt(textBookId.getText()), textBookName.getText(), textAuthorNames.getText(), textPublication.getText(), textDateOfPublication.getText(), Float.parseFloat(textPriceOfBook.getText()), Integer.parseInt(textTotalQuantity.getText()));

                try {
                    FileWriter fw = new FileWriter("book_list.dat", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(b.getBookId() + "*" + b.getBookName() + "*" + b.getAuthorNames() + "*" + b.getPublication() + "*" + b.getDateOfPublication() + "*" + b.getPriceOfBook() + "*" + b.getTotalQuantityToOrder()+"\n");
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }

                showMessageDialog(b,frame);
            }});

        for(int i=0; i<label.length; i++)
        {
        	panel.add(label[i]);
        }
        
        
        panel.add(textBookId);

        panel.add(textBookName);

        panel.add(textAuthorNames);

        panel.add(textPublication);

        panel.add(textDateOfPublication);

        panel.add(textPriceOfBook);

        panel.add(textTotalQuantity);

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
    
    static void showMessageDialog(Book b,JFrame frame)
    {
    	JOptionPane.showMessageDialog(frame, "Book Inserted:\n" +
                "Book ID: " + b.getBookId() + "\n" +
                "Book Name: " + b.getBookName() + "\n" +
                "Author Names: " + b.getAuthorNames() + "\n" +
                "Publication: " + b.getPublication() + "\n" +
                "Date of Publication: " + b.getDateOfPublication() + "\n" +
                "Price of Book: " + b.getPriceOfBook() + "\n" +
                "Total Quantity to Order: " + b.getTotalQuantityToOrder() + "\n" +
                "Total Cost: " + b.getTotalCost());
    }
    
    static void addingComponentsToPanel(Panel panel)
    {
    	
    }
}
