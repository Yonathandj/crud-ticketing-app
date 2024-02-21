import connection.ConnectDatabase;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try(Connection connection = ConnectDatabase.connectDB()) {

            System.out.println("Connected");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}