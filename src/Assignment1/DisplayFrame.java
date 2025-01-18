package Assignment1;

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

    public DisplayFrame(List<Book> books) 
    {
        this.books = books;
        this.mainPanel = new JPanel();
        this.headingLabel = new JLabel("Books Display", JLabel.CENTER);
        this.addBookButton = new JButton("Add New Book");
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
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 250));
        buttonPanel.add(addBookButton); 
        headerPanel.add(buttonPanel, BorderLayout.EAST);
        this.add(headerPanel, BorderLayout.NORTH);
    }

    void createMainPanel() 
    {
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
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
