package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(scrollPane);
        this.setVisible(true);
    }

    void createScrollPane() {
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    }

    void createMainPanel() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(230, 230, 250));
    }

    void createBookPanels() {
        for (Book book : books) {
            JPanel bookPanel = new JPanel(new BorderLayout(10, 5));
            bookPanel.setBackground(Color.WHITE);
            
            JPanel detailsPanel = new JPanel(new GridLayout(4, 2, 5, 5));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
            
            detailsPanel.add(new JLabel("Book ID: " + book.getBookId()));
            detailsPanel.add(new JLabel("Book Name: " + book.getBookName()));
            detailsPanel.add(new JLabel("Author: " + book.getAuthorNames()));
            detailsPanel.add(new JLabel("Publication: " + book.getPublication()));
            detailsPanel.add(new JLabel("Date: " + book.getDateOfPublication()));
            detailsPanel.add(new JLabel("Price: " + book.getPriceOfBook()));
            detailsPanel.add(new JLabel("Quantity: " + book.getTotalQuantityToOrder()));
            detailsPanel.add(new JLabel("Total Cost: " + book.getTotalCost()));
            
            JButton updateButton = new JButton("Update");
            JButton deleteButton = new JButton("Delete");
            
            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Update button clicked for Book ID: " + book.getBookId());
                }
            });
            
            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainPanel.remove(bookPanel);
                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            });
            
            buttonPanel.add(updateButton);
            buttonPanel.add(deleteButton);
            
            bookPanel.add(detailsPanel, BorderLayout.CENTER);
            bookPanel.add(buttonPanel, BorderLayout.SOUTH);
            
            mainPanel.add(bookPanel);
            mainPanel.add(Box.createVerticalStrut(10));
        }
    }
}
