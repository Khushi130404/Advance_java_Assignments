package Assignment1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class BookPanel extends JPanel 
{
    Book book;
    JPanel detailsPanel;
    JPanel buttonPanel;
    JButton updateButton;
    JButton deleteButton;
    JLabel labels[];

    BookPanel(Book book) 
    {
        this.book = book;
        setLayout(new BorderLayout(10, 5)); 
        detailsPanel = new JPanel(new GridLayout(4, 2, 25, 15));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
        labels = createLabels();
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        createBookPanel();
    }

    void createBookPanel() 
    {
        setBackground(new Color(255, 255, 240));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 250), 3),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        detailsPanel.setBackground(new Color(255, 255, 240));
        buttonPanel.setBackground(new Color(255, 255, 240));

        for (JLabel label : labels) 
        {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            detailsPanel.add(label);
        }

        updateDeleteButton();
        add(detailsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void updateDeleteButton() 
    {
        updateButton.setBackground(new Color(173, 216, 230));
        deleteButton.setBackground(new Color(255, 160, 122));

        updateButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        updateButton.setPreferredSize(new Dimension(300, 40));
        deleteButton.setPreferredSize(new Dimension(300, 40));

        updateButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                JOptionPane.showMessageDialog(null, "Update button clicked for Book ID: " + book.getBookId());
                UpdateFrame updateFrame = new UpdateFrame(book);
            }
        });

        deleteButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {    
                BookDeletion bookDeletion = new BookDeletion(book);
                if(bookDeletion.showDeleteConfirmation()==JOptionPane.YES_OPTION)
                {
                	bookDeletion.deleteBook();
                	Container parent = getParent();
                    if (parent != null) 
                    {
                        parent.remove(BookPanel.this);
                        parent.revalidate();
                        parent.repaint();
                    }
                }
            }
        });

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
    }

    JLabel[] createLabels() 
    {
        return new JLabel[]
        {
                new JLabel("Book ID: " + book.getBookId()),
                new JLabel("Book Name: " + book.getBookName()),
                new JLabel("Author: " + book.getAuthorNames()),
                new JLabel("Publication: " + book.getPublication()),
                new JLabel("Date: " + book.getDateOfPublication()),
                new JLabel("Price: " + book.getPriceOfBook()),
                new JLabel("Quantity: " + book.getTotalQuantityToOrder()),
                new JLabel("Total Cost: " + book.getTotalCost()),
        };
    }
    
    Book getBook()
    {
    	return book;
    }
    
}
