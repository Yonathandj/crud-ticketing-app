package services;

import connection.ConnectDatabase;

import java.sql.*;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TicketService {
    public String addNewTicketService(String concertName, String venue, String date, String organizer, double price, double discount) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;

            PreparedStatement ps = connection.prepareStatement("INSERT INTO tickets (id, concert_name, venue, concert_date, organizer, ticket_code, price, discount) VALUES(?, ? ,? ,? , ?, ? ,? ,?)");

            String id = "ticket-" + UUID.randomUUID();
            String ticketCode = "ticketCode" + UUID.randomUUID();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate newDate = LocalDate.parse(date, formatter);

            ps.setString(1, id);
            ps.setString(2, concertName);
            ps.setString(3, venue);
            ps.setDate(4, Date.valueOf(newDate));
            ps.setString(5, organizer);
            ps.setString(6, ticketCode);
            ps.setDouble(7, price);
            ps.setDouble(8, discount);

            ps.executeUpdate();

            ps.close();
            connection.close();

            return id;

        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getAllTicketsService() {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tickets");

            return ps.executeQuery();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }

    public ResultSet getTicketByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM tickets WHERE id = ?");
            ps.setString(1, id);

            return ps.executeQuery();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }


    public int deleteTicketByIdService(String id) {
        try(Connection connection = ConnectDatabase.connectDB()) {
            assert connection != null;
            PreparedStatement ps = connection.prepareStatement("DELETE FROM tickets WHERE id = ?");
            ps.setString(1, id);

            return ps.executeUpdate();
        } catch (SQLException err) {
            throw new RuntimeException("Something went wrong");
        }
    }
}
