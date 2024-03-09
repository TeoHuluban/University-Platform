package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectConfig {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/proiect?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "dD13072003!";


    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
        return connection;
    }

}

