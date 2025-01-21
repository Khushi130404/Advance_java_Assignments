package Assignment1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateFrame extends JFrame
{
	Book book;
	List<Book> books;
	BookList bookList;
    File file;
	JLabel headerLabel;
	JPanel panel;
	String labelText[] = {"Book ID:","Book Name:","Author Names:","Publication:","Date of Publication:","Price of Book:","Total Quantity to Order:"};
    JLabel label[];
    JTextField textField[];
    JButton submitButton;
    JPanel footerPanel;
    
	public UpdateFrame(Book book) 
	{
		this.book = book;
		this.bookList = new BookList();
		this.books = bookList.readBookList();
		this.file = new File("book_list.dat");
		this.headerLabel = new JLabel("Book Details", JLabel.CENTER);
		this.panel = new JPanel();	
		this.label = new JLabel[labelText.length];
		this.textField = new JTextField[labelText.length];
		this.submitButton = new JButton("Update Book");
		this.footerPanel = new JPanel();
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
		createTextField();
	}
	
	void createTextField()
	{
		textField[0].setEditable(false);
		textField[0].setText(""+book.getBookId());
		textField[1].setText(""+book.getBookName());
		textField[2].setText(""+book.getAuthorNames());
		textField[3].setText(""+book.getPublication());
		textField[4].setText(""+book.getDateOfPublication());
		textField[5].setText(""+book.getPriceOfBook());
		textField[6].setText(""+book.getTotalQuantityToOrder());
	}
	
	
	void createSubmitButton()
	{
        submitButton.setPreferredSize(new Dimension(300, 40));
        submitButton.setBackground(new Color(146, 145, 194));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);
        
        submitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Book b = new Book(Integer.parseInt(textField[0].getText()), textField[1].getText(), textField[2].getText(), textField[3].getText(), textField[4].getText(), Float.parseFloat(textField[5].getText()), Integer.parseInt(textField[6].getText()));
                updateBook(b);
                showMessageDialog();
            }
        });
	}
	
	void showMessageDialog()
    {
    	JOptionPane.showMessageDialog(this, "Book Updated Successfully...!");
    }
	
	void updateBook(Book b)
	{
	    try  
	    {
	    	FileWriter fileWriter = new FileWriter(file);
	    	BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
	    	
	        for (Book bk : books) 
	        {
	        	if(bk.bookId == book.bookId) bk = b;
	      
	            bufferedWriter.write(bk.getBookId() + "*" + 
	                         bk.getBookName() + "*" + 
	                         bk.getAuthorNames() + "*" + 
	                         bk.getPublication() + "*" + 
	                         bk.getDateOfPublication() + "*" + 
	                         bk.getPriceOfBook() + "*" + 
	                         bk.getTotalQuantityToOrder());
	            bufferedWriter.newLine();
	        }
	        
	        bufferedWriter.close();
	        fileWriter.close();
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
	        System.out.println("Error writing to file!");
	    }
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
