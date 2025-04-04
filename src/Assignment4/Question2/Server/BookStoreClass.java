package Assignment4.Question2.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.*;

public class BookStoreClass extends UnicastRemoteObject implements BookStore {
    protected BookStoreClass() throws RemoteException {
        super();
    }

    @Override
    public List<Map<String, Object>> getBookInfo(int id) throws RemoteException {
        List<Map<String, Object>> bookList = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/books?characterEncoding=latin1", "root", "khushi");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM book WHERE bookId = ?");
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> book = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    book.put(metaData.getColumnName(i), rs.getObject(i));
                }
                bookList.add(book);
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookList;
    }
}
