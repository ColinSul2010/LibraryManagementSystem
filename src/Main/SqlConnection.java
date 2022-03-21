package Main;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnection {

    public static Connection dbConnect() {
        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:identifier.sqlite");
            return conn;
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
