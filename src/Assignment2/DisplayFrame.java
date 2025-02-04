package Assignment2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DisplayFrame extends JFrame 
{
    List<Book> books;
    JPanel mainPanel;
    JScrollPane scrollPane;
    JLabel headingLabel;
    JButton addBookButton;
    JButton incPriceButton;

    public DisplayFrame(List<Book> books) 
    {
        this.books = books;
        this.mainPanel = new JPanel();
        this.headingLabel = new JLabel("Books Display", JLabel.CENTER);
        this.addBookButton = new JButton("Add New Book");
        this.incPriceButton = new JButton("Increase Price of Book");
        scrollPane = new JScrollPane(mainPanel);
        createFrame();
    }

    void createFrame() 
    {
        createHeaderPanel();
        createMainPanel();
        createBookPanels();
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(scrollPane);
        setVisible(true);
    }

    void createHeaderPanel() 
    {
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());
        headerPanel.setBackground(new Color(245, 245, 250)); 

        headingLabel.setFont(new Font("Arial", Font.BOLD, 28));
        headingLabel.setForeground(new Color(0, 0, 0)); 
        headerPanel.add(headingLabel, BorderLayout.CENTER);

        addBookButton = new JButton("+");      
        addBookButton.setFont(new Font("Arial", Font.BOLD, 28));
        addBookButton.setPreferredSize(new Dimension(50, 50));
        
        addBookButton.addActionListener(new ActionListener() 
        {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				InsertionFrame insertionFrame = new InsertionFrame();
			}
		});

        incPriceButton = new JButton("↑");      
        incPriceButton.setFont(new Font("Arial", Font.BOLD, 30));
        incPriceButton.setPreferredSize(new Dimension(50, 50));
        
        incPriceButton.addActionListener(new ActionListener() 
        {	
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				IncreasePrice increasePrice = new IncreasePrice();	
		        JOptionPane.showMessageDialog(null, "Book prices have been updated!", "Price Update", JOptionPane.INFORMATION_MESSAGE);
		        refreshFrame();
			}
		});
        
        JPanel buttonPanelRight = new JPanel();
        buttonPanelRight.setBackground(new Color(245, 245, 250));
        buttonPanelRight.add(addBookButton);

        JPanel buttonPanelLeft = new JPanel();
        buttonPanelLeft.setBackground(new Color(245, 245, 250));
        buttonPanelLeft.add(incPriceButton);

        headerPanel.add(buttonPanelRight, BorderLayout.EAST);
        headerPanel.add(buttonPanelLeft, BorderLayout.WEST);
        
        this.add(headerPanel, BorderLayout.NORTH);
    }

    void createMainPanel() 
    {
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    void refreshFrame() 
    {
        BookList booklist = new BookList();
        books = booklist.readBookList();
        mainPanel.removeAll(); 
        createBookPanels();
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    
    void createBookPanels() 
    {
        for (Book book : books) 
        {
            BookPanel bookPanel = new BookPanel(book);
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(15)); 
        }
    }
}
