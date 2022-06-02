package util;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConnect {

    private Connection connect;

    public Connection getConnect() {
        if (this.connect == null) {

            try {
                Class.forName("org.postgresql.Driver");
                this.connect = DriverManager.getConnection("jdbc:postgresql://localhost:5433/onlinemarketsitesi", "postgres", "1234");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return connect;
    }

}