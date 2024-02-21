package services;

import connection.ConnectDatabase;

import java.sql.*;
import java.util.UUID;

public class UserService {
    public String addNewUserService(String name, String phoneNumber, String email, String address) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            String id = "ticket-" + UUID.randomUUID();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (id, name, phone_number, email, address) VALUES(?, ? ,?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, phoneNumber);
            ps.setString(5, email);
            ps.setString(6, address);
            ps.executeUpdate();

            ps.close();
            connection.close();

            return id;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getAllUsers() {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            ps.close();
            rs.close();
            connection.close();

            return rs;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getUserByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            ps.close();
            rs.close();
            connection.close();

            return rs;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public int updateUserByIdService(String id, String name, String phoneNumber, String email, String address) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, phoneNumber = ?, email = ?, address = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setString(2, phoneNumber);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, id);
            int affectedRow = ps.executeUpdate();

            ps.close();
            connection.close();

            return affectedRow;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public int deleteUserByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setString(1, id);
            int affectedRow = ps.executeUpdate();

            ps.close();
            connection.close();

            return affectedRow;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
