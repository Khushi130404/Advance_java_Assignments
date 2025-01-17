package Assignment1;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class DisplayFrame extends JFrame
{
	List<Book> books;
    JPanel mainPanel;
    JScrollPane scrollPane;

	public DisplayFrame(List<Book> books) 
	{
		this.books = books;
		this.mainPanel = new JPanel();
		scrollPane = new JScrollPane(mainPanel);
		createFrame();
	}
	
	void createFrame()
	{
		createMainPanel();
		createBookPanels();
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(scrollPane);
        this.setVisible(true);
	}
	
	void createScrollPane()
	{
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	}
	
	void createMainPanel()
	{
		 mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	     mainPanel.setBackground(new Color(230, 230, 250));
	}
	
	void createBookPanels()
	{
		for(Book book : books)
		{
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
	}
}