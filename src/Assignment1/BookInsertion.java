package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

class DisplayFrame extends JFrame
{
	JLabel headerLabel;
	JPanel panel;
	String labelText[] = {"Book ID:","Book Name:","Author Names:","Publication:","Date of Publication:","Price of Book:","Total Quantity to Order:"};
    JLabel label[];
    JTextField textField[];
    JButton submitButton;
    JPanel footerPanel;

	public DisplayFrame() 
	{
		headerLabel = new JLabel("Insert New Book Details", JLabel.CENTER);
		panel = new JPanel();	
		label = new JLabel[labelText.length];
		textField = new JTextField[labelText.length];
		submitButton = new JButton("Insert Book");
		footerPanel = new JPanel();
		createFrame();
	}
	
	void createFrame()
	{
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
        panel.setLayout(new GridLayout(9, 2, 10, 10));
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

public class BookInsertion 
{
    public static void main(String[] args) 
    {	
    	DisplayFrame frame = new DisplayFrame();
    }
}
