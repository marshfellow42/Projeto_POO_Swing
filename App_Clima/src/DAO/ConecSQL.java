package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConecSQL {

    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10667230?user=sql10667230&password=hGpva5MKx8";
            conn = DriverManager.getConnection(url);

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "ConecSQL: " + error);
        }

        return conn;

    }
}
