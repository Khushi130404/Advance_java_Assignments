package Assignment1;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Book_Display {

    public static void main(String[] args) {

        JFrame j = new JFrame("Book Display");
        j.setSize(1300, 800);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setLocationRelativeTo(null);

        List<Book> books = new ArrayList<>();
        try {
            FileReader fr = new FileReader("book_list.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "*");
                Book b = new Book(
                    Integer.parseInt(st.nextToken()),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    st.nextToken(),
                    Float.parseFloat(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Float.parseFloat(st.nextToken())
                );
                books.add(b);
            }
            br.close();
            fr.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }

        String[] columnNames = {
            "Book ID", "Book Name", "Author Names", "Publication",
            "Date of Publication", "Price of Book", "Total Quantity to Order", "Total Cost"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Book book : books) {
            Object[] rowData = {
                book.getBookId(),
                book.getBookName(),
                book.getAuthorNames(),
                book.getPublication(),
                book.getDateOfPublication(),
                book.getPriceOfBook(),
                book.getTotalQuantityToOrder(),
                book.getTotalCost()
            };
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        table.setFont(new Font("Arial", Font.PLAIN, 17));
        table.setRowHeight(40);
        
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setBackground(new Color(70, 130, 180));  
        header.setForeground(Color.WHITE);
        header.setPreferredSize(new Dimension(header.getWidth(), 40));

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        headerRenderer.setFont(new Font("Arial", Font.BOLD, 18));
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    component.setBackground(new Color(245, 245, 245));
                } else {
                    component.setBackground(Color.WHITE);
                }
                return component;
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setBackground(new Color(230, 230, 250));

        j.add(panel);
        j.setVisible(true);
    }
}
