package services;

import connection.ConnectDatabase;
import implementations.services.UserServiceImplementation;

import java.sql.*;
import java.util.UUID;

public class UserService implements UserServiceImplementation {
    public UserService() {
    }

    public String addNewUserService(String name, String phoneNumber, String email, String address) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            String id = "user-" + UUID.randomUUID();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (id, name, phone_number, email, address) VALUES(?, ? ,?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, phoneNumber);
            ps.setString(4, email);
            ps.setString(5, address);
            ps.executeUpdate();

            return id;
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getAllUsersService() {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
            return ps.executeQuery();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getUserByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            ResultSet rs = checkExistenceUser(id);
            if(!rs.next()) {
                throw new Exception("No id found");
            }

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);

            return ps.executeQuery();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        } catch (Exception err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    public int updateUserByIdService(String id, String name, String phoneNumber, String email, String address) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            ResultSet rs = checkExistenceUser(id);
            if(!rs.next()) {
                throw new Exception("No id found");
            }

            PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, phone_number = ?, email = ?, address = ? WHERE id = ?");
            ps.setString(1, name);
            ps.setString(2, phoneNumber);
            ps.setString(3, email);
            ps.setString(4, address);
            ps.setString(5, id);

            return ps.executeUpdate();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        } catch (Exception err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    public int deleteUserByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            ResultSet rs = checkExistenceUser(id);
            if(!rs.next()) {
                throw new Exception("No id found");
            }

            PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ?");
            ps.setString(1, id);

            return ps.executeUpdate();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        } catch (Exception err) {
            throw new RuntimeException(err.getMessage());
        }
    }

    public ResultSet checkExistenceUser(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, id);

            return ps.executeQuery();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
