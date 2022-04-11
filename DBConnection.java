package util;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public Connection connect() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = (Connection) DriverManager.getConnection("jdbc:postgresql://localhost/onlinemarketsitesi", "postgres", "123456");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return c;
    }
}
