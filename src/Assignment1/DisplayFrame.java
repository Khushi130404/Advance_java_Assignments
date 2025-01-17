package Assignment1;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
