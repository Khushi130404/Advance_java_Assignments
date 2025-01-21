package Assignment1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class InsertionFrame extends JFrame
{
	JLabel headerLabel;
	JPanel panel;
	String labelText[] = {"Book ID:","Book Name:","Author Names:","Publication:","Date of Publication:","Price of Book:","Total Quantity to Order:"};
    JLabel label[];
    JTextField textField[];
    JButton submitButton;
    JPanel footerPanel;

	public InsertionFrame() 
	{
		this.headerLabel = new JLabel("Insert New Book Details", JLabel.CENTER);
		this.panel = new JPanel();	
		this.label = new JLabel[labelText.length];
		this.textField = new JTextField[labelText.length];
		this.submitButton = new JButton("Insert Book");
		this.footerPanel = new JPanel();
		createFrame();
	}
	
	void createFrame()
	{
        this.setBackground(new Color(245, 239, 255));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 600);
        this.setLayout(new BorderLayout(10, 10));
        createComponents();
        this.add(headerLabel, BorderLayout.NORTH);
        addingComponentsToPanel();
        this.add(panel, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);
        this.setVisible(true);
	}
	
	void createComponents()
	{
		createHeader();
        createPanel();
        createLabel();
        createSubmitButton();
        createFooter();
	}
	
	void createHeader()
	{
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
	}

	void createPanel()
	{
        panel.setLayout(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
	}
	
	void createLabel()
	{
		for(int i=0; i<label.length; i++)
        {
        	label[i] = new JLabel(labelText[i]);
        	textField[i] = new JTextField();
        }
	}
	
	
	void createSubmitButton()
	{
        submitButton.setForeground(Color.WHITE);
        submitButton.setPreferredSize(new Dimension(300, 40));
        submitButton.setBackground(new Color(146, 145, 194));
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

                showMessageDialog(b);
            }});
	}
	
    void showMessageDialog(Book b)
    {
    	JOptionPane.showMessageDialog(this, "Book Inserted:\n" +
                "Book ID: " + b.getBookId() + "\n" +
                "Book Name: " + b.getBookName() + "\n" +
                "Author Names: " + b.getAuthorNames() + "\n" +
                "Publication: " + b.getPublication() + "\n" +
                "Date of Publication: " + b.getDateOfPublication() + "\n" +
                "Price of Book: " + b.getPriceOfBook() + "\n" +
                "Total Quantity to Order: " + b.getTotalQuantityToOrder() + "\n" +
                "Total Cost: " + b.getTotalCost());
    }

	void createFooter()
	{
	    footerPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
	    footerPanel.add(submitButton);
	}
	
    void addingComponentsToPanel()
    {
    	for(int i=0; i<label.length; i++)
        {
        	panel.add(label[i]);
        	panel.add(textField[i]);
        }
    }
}
