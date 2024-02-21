package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectDatabase {

    public ConnectDatabase() {
    }

    public static Connection connectDB() {
        try {
            return DriverManager.getConnection(System.getenv("DB_URL"), System.getenv("DB_USERNAME"), System.getenv("DB_PASSWORD"));
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
        return null;
    }
}
