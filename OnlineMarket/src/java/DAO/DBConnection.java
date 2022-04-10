
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection {

    private Connection connection;

    public Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");  
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/cms", "postgres", "12345");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

}
