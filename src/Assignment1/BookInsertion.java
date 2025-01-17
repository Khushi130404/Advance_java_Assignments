package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class BookInsertion 
{
    public static void main(String[] args) 
    {	
    	JFrame frame = createFrame();
        frame.setVisible(true);
    }
    
    static void createLabel(JFrame frame,JPanel panel)
    {
    	String labelText[] = {"Book ID:","Book Name:","Author Names:","Publication:","Date of Publication:","Price of Book:","Total Quantity to Order:"};
        JLabel label[] = new JLabel[labelText.length];
        JTextField textField[] = new JTextField[labelText.length];
        
        for(int i=0; i<label.length; i++)
        {
        	label[i] = new JLabel(labelText[i]);
        	textField[i] = new JTextField();
        }
        JButton submitButton = submitButton(frame,textField);
        addingComponentsToPanel(panel,label,textField);
        addingComponentsToFrame(frame,panel,submitButton);
    }
    
    static JFrame createFrame()
    {
        JFrame frame = new JFrame("Book Insertion Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 600);
        frame.setLayout(new BorderLayout(10, 10));

        // Header
        JLabel headerLabel = new JLabel("Insert New Book Details", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        frame.add(headerLabel, BorderLayout.NORTH);

        // Form Panel
    	JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        createLabel(frame,panel);
        return frame;
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
    
    static JButton submitButton(JFrame frame,JTextField textField[])
    {
    	JButton submitButton = new JButton("Insert Book");
        submitButton.setBackground(new Color(72, 191, 227));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);
        
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book b = new Book(Integer.parseInt(textField[0].getText()), textField[1].getText(), textField[2].getText(), textField[3].getText(), textField[4].getText(), Float.parseFloat(textField[5].getText()), Integer.parseInt(textField[6].getText()));

                try {
                    FileWriter fw = new FileWriter("book_list.dat", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(b.getBookId() + "*" + b.getBookName() + "*" + b.getAuthorNames() + "*" + b.getPublication() + "*" + b.getDateOfPublication() + "*" + b.getPriceOfBook() + "*" + b.getTotalQuantityToOrder());
                    bw.newLine();
                    bw.close();
                    fw.close();
                } catch (Exception exp) {
                    exp.printStackTrace();
                }

                showMessageDialog(b,frame);
            }});
        return submitButton;
    }
    
    static void addingComponentsToFrame(JFrame frame,JPanel panel,JButton submitButton)
    {
        // Footer Panel for Button
        JPanel footerPanel = new JPanel();
        footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        footerPanel.add(submitButton);

        // Adding Components to Frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(footerPanel, BorderLayout.SOUTH);

    }
    
    static void addingComponentsToPanel(JPanel panel,JLabel label[],JTextField textField[])
    {
    	for(int i=0; i<label.length; i++)
        {
        	panel.add(label[i]);
        	panel.add(textField[i]);
        }
    }
}
