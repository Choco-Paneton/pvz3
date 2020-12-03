
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Coon_sqlite {

    public static Connection connectSQLite() {

        Connection conn_sqlite = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            String dbURL = "jdbc:sqlite:us_db.db?foreign_keys=on;";
            
            conn_sqlite = DriverManager.getConnection(dbURL);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conn_sqlite;
    }

    public static void closeSQLite(Connection conn_sqlite) {
        try {
            if (conn_sqlite != null) {
                conn_sqlite.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
