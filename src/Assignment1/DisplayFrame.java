package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

class BookPanel extends JPanel {
    Book book;
    JPanel detailsPanel;
    JPanel buttonPanel;
    JButton updateButton;
    JButton deleteButton;
    JLabel labels[];

    BookPanel(Book book) {
        this.book = book;
        setLayout(new BorderLayout(10, 5)); 
        detailsPanel = new JPanel(new GridLayout(4, 2, 25, 15));
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20,10));
        labels = createLabels();
        deleteButton = new JButton("Delete");
        updateButton = new JButton("Update");
        createBookPanel();
    }

    void createBookPanel() {
        setBackground(new Color(255, 255, 240));
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 250), 3),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        detailsPanel.setBackground(new Color(255, 255, 240));
        buttonPanel.setBackground(new Color(255, 255, 240));

        for (JLabel label : labels) {
            label.setFont(new Font("Arial", Font.BOLD, 14));
            detailsPanel.add(label);
        }

        updateDeleteButton();
        add(detailsPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void updateDeleteButton() {
        updateButton.setBackground(new Color(173, 216, 230));
        deleteButton.setBackground(new Color(255, 160, 122));

        updateButton.setFont(new Font("Arial", Font.BOLD, 14));
        deleteButton.setFont(new Font("Arial", Font.BOLD, 14));

        updateButton.setPreferredSize(new Dimension(300, 40));
        deleteButton.setPreferredSize(new Dimension(300, 40));

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Update button clicked for Book ID: " + book.getBookId());
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Container parent = getParent();
                if (parent != null) {
                    parent.remove(BookPanel.this);
                    parent.revalidate();
                    parent.repaint();
                }
            }
        });

        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
    }

    JLabel[] createLabels() {
        return new JLabel[]{
                new JLabel("Book Name: " + book.getBookName()),
                new JLabel("Author: " + book.getAuthorNames()),
                new JLabel("Publication: " + book.getPublication()),
                new JLabel("Date: " + book.getDateOfPublication()),
                new JLabel("Price: " + book.getPriceOfBook()),
                new JLabel("Quantity: " + book.getTotalQuantityToOrder()),
                new JLabel("Total Cost: " + book.getTotalCost()),
                new JLabel("Book ID: " + book.getBookId())
        };
    }
}

public class DisplayFrame extends JFrame {
    List<Book> books;
    JPanel mainPanel;
    JScrollPane scrollPane;

    public DisplayFrame(List<Book> books) {
        this.books = books;
        this.mainPanel = new JPanel();
        scrollPane = new JScrollPane(mainPanel);
        createFrame();
    }

    void createFrame() {
        createMainPanel();
        createBookPanels();
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(scrollPane);
        setVisible(true);
    }

    void createMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(245, 245, 250));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }

    void createBookPanels() {
        for (Book book : books) {
            BookPanel bookPanel = new BookPanel(book);
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(15));
        }
    }
}
